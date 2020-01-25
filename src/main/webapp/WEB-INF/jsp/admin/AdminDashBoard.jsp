
<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 25-01-2020
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>DashBoard</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/DashBoard.css"/>" />
    <style>

    </style>
</head>
<body>

<div style="display:inline;">
    <ul class="list">
        <c:forEach var="feature" items="${features}">
            <li class="listItem">
                <a href="${contextPath}/${feature.link}" class="link">
                    <div class="box">
                        <img height="60px" width="60px" src="<c:url value="${feature.image}" />"><br>
                        <strong>${feature.name}</strong>
                    </div>
                </a>
            </li>

        </c:forEach>

    </ul>
</div>




</body>
</html>
