<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 29-01-2020
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>DashBoard</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/DashBoard.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>



</head>
<body class="body">



<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">
    <div class="containerHead">
        <b>Upload Via File</b>
    </div>

    <br><br>
    <form action="${contextPath}/admin/saveFile"  method="post" enctype="multipart/form-data">
        <input type="file" name="file"><br><br>
        <input type="submit" class="btn btn-success" value="Submit">
    </form>
</div>


<%@ include file="/resources/html/Footer.html" %>



</body>
</html>
