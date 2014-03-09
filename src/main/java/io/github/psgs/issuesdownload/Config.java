package io.github.psgs.issuesdownload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String githubtoken;

    public static void loadConfiguration() throws FileNotFoundException, IOException {

        Properties config = new Properties();
        config.load(new FileInputStream("IssuesDownload.properties"));

        githubtoken = config.getProperty("GitHub-Token");

    }
}