Issues Download [![Build Status](https://travis-ci.org/psgs/IssuesDownload.png?branch=master)](https://travis-ci.org/psgs/IssuesDownload)
====================

Issues Download is a lightweight java application that will pull issues from a github.com repository, and write them to a .csv file.
IssuesDownload uses Eclipse eGit to connect to GitHub's api, and opencsv for simplicity when writing issues.

To run the application once compiled, simply run the .jar file that should have been compiled.
Once the process is complete, a .csv file should contain issue information in the .jar file directory.
Please Note: When the .jar file is run, it will overwrite any other issues.csv files in the jar file directory.

CSV Format
----------

The .csv format used is as follows:
Id, Title, Creator, Assignee, Milestone, State, Body Text.

The first line of the csv file shows the format used, and therefore does not display any information pulled from issues.


Compiling
---------

IssuesDownload uses [Apache Maven 3](http://maven.apache.org/) to compile!

To compile IssuesDownload, simply install [Apache Maven](http://maven.apache.org/), and run:
```mvn -f pom.xml clean install -P shade```

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/psgs/issuesdownload/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

