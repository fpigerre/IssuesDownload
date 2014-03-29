Issues Download [![Build Status](https://travis-ci.org/psgs/IssuesDownload.png?branch=master)](https://travis-ci.org/psgs/IssuesDownload)    [![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/psgs/issuesdownload/trend.png)](https://bitdeli.com/free "Bitdeli Badge")
====================

Issues Download is a lightweight java application that will pull issues from a github.com repository, and write them to a .csv file. IssuesDownload uses [Kohsuke Kawaguchi's GitHub API for Java](http://github-api.kohsuke.org) to connect to GitHub when writing issues.

To run the application once compiled, simply run the .jar file that should have been compiled.
Once the process is complete, a .csv file should contain issue information in the .jar file directory.
Please Note: When the .jar file is run, it will overwrite any other issues.csv files in the jar file directory.

If downloading Issues doesn't work after multiple tries, you may need to copy the [IssuesDownload properties file](https://github.com/psgs/IssuesDownload/blob/master/src/main/resources/IssuesDownload.properties), and place it in the same directory as the .jar file, then edit the file to contain your [personal or an application access token](https://help.github.com/articles/creating-an-access-token-for-command-line-use).

Screenshots
-----------

![Screenshot One](http://i.imgur.com/FBdjxlQ.png)

CSV Format
----------

The .csv format used is as follows:
Id, Title, Creator, Assignee, Milestone, State, Body Text.

The first line of the csv file shows the format used, and therefore does not display any information pulled from issues.

ID | Title | Creator | Assignee | Milestone | State | Body Text
------------ | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
1 | Add a Bitdeli Badge to README | bitdeli-chef | psgs | First-Release | CLOSED | Pull request made by @psgs at https://bitdeli.com

Compiling
---------

IssuesDownload uses [Apache Maven 3](http://maven.apache.org/) to compile!

To compile IssuesDownload, simply install [Apache Maven](http://maven.apache.org/), and run:
```mvn -f pom.xml clean install -P shade```
