package io.github.psgs.issuesdownload;

import io.github.psgs.issuesdownload.gui.GUI;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class IssuesDownload {

    public static void main(String[] args) {
        try {
            Config.loadConfiguration();
        } catch (IOException ex) {

        }
        GUI.main(args);
    }

    public static String saveIssues(String repoDetails) {
        String[] repoInfo = repoDetails.split("/");
        String repoOwner = repoInfo[0];
        String repoName = repoInfo[1];

        GitHubClient client = new GitHubClient();
        client.setCredentials(Config.githubuser, Config.githubpass);

        try {
            FileWriter writer = new FileWriter("issues.csv");
            writer.append("Id, Title, Creator, Assignee, Milestone, State, Body Text");
            writer.append("\n");

            for (Issue issue : getAllIssues(client, repoOwner, repoName)) {
                writer.append(String.valueOf(issue.getId()) + ",");
                writer.append(issue.getTitle() + ",");
                writer.append(issue.getUser().getName() + ",");
                writer.append(issue.getAssignee().getName() + ",");
                writer.append(issue.getMilestone().getTitle() + ",");
                writer.append(issue.getState() + ",");
                writer.append(issue.getBodyText());
                writer.append("\n");
            }
            writer.flush();
            writer.close();
            return "Download Complete!";
        } catch (IOException ex) {
            System.out.println("An IOException has occured!");
            ex.printStackTrace();
            if (ex.getMessage().equalsIgnoreCase("api.github.com")) {
                return "An error has occurred reaching " + ex.getMessage() + "! Please check your network connection.";
            }
        }
        return "An error has occured!";
    }

    public static List<Issue> getAllIssues(GitHubClient client, String repoOwner, String repoName) throws IOException {
        IssueService service = new IssueService(client);
        return service.getIssues(repoOwner, repoName,
                Collections.singletonMap(IssueService.FILTER_STATE,
                        IssueService.STATE_OPEN));
    }
}
