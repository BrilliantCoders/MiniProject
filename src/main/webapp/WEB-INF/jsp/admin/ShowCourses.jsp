<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 03-04-2020
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<html>
<head>
    <title>Show Courses</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ShowStudentList.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">

    <div class="containerHead">
       All Courses
    </div>

    <div style="width: 100%;alignment: center;text-align: left">
        <ul>
            <c:forEach var="course" items="${Courses}">
                <li style="box-shadow: 0 3px 3px 0 rgba(0,0,0,0.2);padding: 10px">
                    <b><label style="color: blue;size: 20px">${course.subName}</label></b><br>
                    Course - ${course.courseName}<br>
                    Branch - ${course.branchName}<br>
                    Semester - ${course.semester}<br>
                    Year - ${course.year}<br>
                </li>
                <br><br>
            </c:forEach>
        </ul>

    </div>



</div>

<%@ include file="/resources/html/Footer.html" %>


</body>
</html>
