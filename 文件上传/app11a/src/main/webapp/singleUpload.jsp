<%--
  Created by IntelliJ IDEA.
  User: Sbbbbb
  Date: 2018/12/4
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
</head>
<body>
<h1>Select a file to upload</h1>
<form action="singleUpload" enctype="multipart/form-data" method="post">
    Author:<input type="text" name="author"><br/>
    Select file to upload <input type="file" name="filename"><br/>
    <input type="submit" value="Upload">
</form>
</body>
</html>
