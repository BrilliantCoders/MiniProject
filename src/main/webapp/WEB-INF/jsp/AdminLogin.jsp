<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 25-01-2020
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Login Page Hello ${name}

    <form action="${contextPath}/submit" method="post">

        <input type="text" name="email">
        <input type="submit" value="Submit Me">

    </form>


</body>
</html>
