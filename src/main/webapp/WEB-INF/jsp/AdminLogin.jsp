<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 01-02-2020
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/DashBoard.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>

<div class="container">

    <div class="containerHead">
        Admin Login
    </div>
    <%@ include file="/resources/html/Footer.html" %>

</body>
</html>
