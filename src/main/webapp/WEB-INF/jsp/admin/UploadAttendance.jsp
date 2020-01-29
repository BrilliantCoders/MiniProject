<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 29-01-2020
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <div class="containerHead">
        <b>Upload Via File</b>
    </div>


    <form action="${contextPath}/saveFile"  method="post" enctype="multipart/form-data">
        <input type="file" name="file"><br><br>
        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>
