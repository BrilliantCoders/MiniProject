
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
        DashBoard
    </div>


<div style="display:inline;margin-left:15%;margin-right: 15% ">


    <ul class="list">
        <c:forEach var="feature" items="${features}">
            <li class="listItem">
                <a href="${contextPath}/${feature.link}" class="link">
                    <div class="box">
                        <img height="66px" width="66px" src="<c:url value="${feature.image}" />"><br>
                        <div style="height: 50px;padding: 5px;size: 21px">
                            ${feature.name}
                        </div>

                    </div>
                </a>
            </li>

        </c:forEach>

    </ul>
</div>
</div>



<%@ include file="/resources/html/Footer.html" %>




</body>
</html>
