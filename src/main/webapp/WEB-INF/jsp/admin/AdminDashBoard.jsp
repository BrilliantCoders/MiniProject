
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


    <script>
        $(function(){
            $(".header").load("/admin/Header");
            $("#footer").load("<c:url value="/resources/html/Footer.html"/>");
        });
    </script>
</head>
<body style="margin: 0px;padding: 0px;">

<div class="header" >

</div>

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
                        <img height="60px" width="60px" src="<c:url value="${feature.image}" />"><br>
                        <span style="height: 50px;margin-top: 8px">${feature.name}</span>
                    </div>
                </a>
            </li>

        </c:forEach>

    </ul>
</div>
</div>

<div id="footer">


</div>

</body>
</html>
