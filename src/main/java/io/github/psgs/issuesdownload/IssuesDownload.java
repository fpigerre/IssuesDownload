package io.github.psgs.issuesdownload;

import au.com.bytecode.opencsv.CSVWriter;
import io.github.psgs.issuesdownload.gui.GUI;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class IssuesDownload {

    public static void main(String[] args) {
        try {
        Config.loadConfiguration();
        } catch(IOException ex) {

        }
        GUI.main(args);
    }

    public static String saveIssues(String repoDetails) {
        String[] repoInfo = repoDetails.split("/");
        String repoOwner = repoInfo[0];
        String repoName = repoInfo[1];

        GitHubClient client = new GitHubClient();
        client.setCredentials(Config.githubuser, Config.githubpass);

        IssueService issueService = new IssueService(client);

        try {
            CSVWriter writer = new CSVWriter(new FileWriter("issues.csv"), '\t');
            String[] header = {"Id", "Title", "Creator", "Assignee", "Milestone", "State", "Body Text"};
            writer.writeNext(header);

            for (Issue issue : issueService.getIssues(repoOwner, repoName, null)) {
                String[] data = {String.valueOf(issue.getId()), issue.getTitle(), issue.getUser().getName(), issue.getAssignee().getName(), issue.getMilestone().getTitle(), issue.getState(), issue.getBodyText()};
                writer.writeNext(data);
            }
            writer.close();
            return "Download Complete!";
        } catch (IOException ex) {
            System.out.println("An IOException has occured!");
            ex.printStackTrace();
            if (ex.getMessage().equalsIgnoreCase("api.github.com")) {
                return "An error has occured, reaching " + ex.getMessage() + "! Please check your network connection.";
            }
        }
        return "An error has occured!";
    }
}
