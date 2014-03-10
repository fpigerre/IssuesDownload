var repoOwner = document.getElementById("repositoryOwner");
var repoName = document.getElementById("repositoryName");

var builder = new BlobBuilder();
var data = ["ID", "Title", "Creator", "Assignee", "Milestone", "State", "Body Text"];
builder.append(data);



for (var i = 0; i < issues.size; i++) {
    var issue = issues[i];
    builder.append(issue.get);
    builder.append(issue.title);
    builder.append(issue.author);
    builder.append("Assignee");
    builder.append(issue.label);
    builder.append(issue.readyState);
    builder.append(issue.body);
}

var blob = builder.getBlob();
blob = blob.slice(0, blob.size, 'text/csv;charset=utf-8;');
var fr = new FileReader();
fr.onload = function() {document.location = this.result;}
fr.readAsDataURL(blob);

/*var downloadCsv = function (data) {
    var a = window.document.createElement('a');
    a.href = window.URL.createObjectURL(new Blob(data, {type: 'text/csv;charset=utf-8;'}));
    a.download = 'issues.csv';
}*/