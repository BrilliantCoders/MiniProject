<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 29-01-2020
  Time: 22:32
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
        <br>
        Submitted Successfully
        <br><br>
        <form action="${contextPath}/adminDashboard">
            <input type="submit"class="btn btn-success" value="Back to HomePage">
        </form>

    </div>
</div>



<%@ include file="/resources/html/Footer.html" %>




</body>
</html>
