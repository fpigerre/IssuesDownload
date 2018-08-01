package io.github.psgs.issuesdownload;

import io.github.psgs.issuesdownload.gui.GUI;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.FileWriter;
import java.io.IOException;

public class IssuesDownload {

    public static void main(String[] args) {
        try {
            Config.loadConfiguration();
        } catch (Throwable t) {
            System.out.println("An error " + t.getClass().getName() + " has occurred reaching '" + t.getMessage() + "' while loading the configuration!");
            t.printStackTrace();
        }
        GUI.main(args);
    }

    public static String saveIssues(String repoDetails, GHIssueState issueState) {

        String[] repoInfo = repoDetails.split("/");

        try {
            GitHub github = GitHub.connectUsingOAuth(Config.githubtoken);
            GHRepository repository = github.getUser(repoInfo[0]).getRepository(repoInfo[1]);

            FileWriter writer = new FileWriter("issues.csv");
            writer.append("Id, Title, Creator, Assignee, Milestone, State, Body Text");
            writer.append("\n");

            for (GHIssue issue : repository.getIssues(issueState)) {
                writer.append(String.valueOf(issue.getNumber()) + ",");
                writer.append(issue.getTitle() + ",");
                writer.append(issue.getUser().getLogin() + ",");
                if (issue.getAssignee() != null) {
                    writer.append(issue.getAssignee().getName() + ",");
                } else {
                    writer.append(" ,");
                }
                if (issue.getMilestone() != null) {
                    writer.append(issue.getMilestone().getTitle() + ",");
                } else {
                    writer.append(" ,");
                }
                writer.append(issue.getState() + ",");
                writer.append(issue.getBody() + ",");
                writer.append("\n");
            }
            writer.flush();
            writer.close();
            return "Download Complete!";
        } catch (Throwable t) {
            System.out.println("An error " + t.getClass().getName() + " has occurred reaching '" + t.getMessage() + "'!");
            t.printStackTrace();
            return "An error " + t.getClass().getName() + " has occurred reaching '" + t.getMessage() + "'!";
        }
        //return "An error has occurred!";
    }
}
