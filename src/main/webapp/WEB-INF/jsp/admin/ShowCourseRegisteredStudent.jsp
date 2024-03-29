<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 28-01-2020
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ShowStudentList.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body class="body">

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">

    <div class="containerHead">
        DashBoard
    </div>

    <div style="width: 100%;alignment: center;text-align: center">
        <table>
            <tr>

            </tr>
            <c:forEach var="student" items="${StudentList}">
                <tr id="${student.rollNo}">
                    <td>${student.rollNo}</td>
                    <td>${student.regNo}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.password}</td>


                </tr>

            </c:forEach>
        </table>

    </div>

    <div>
        <form action="${contextPath}/admin/addCourseStudent">
            <input type="submit" value="Submit" class="btn btn-success">
        </form>
    </div>


</div>

<%@ include file="/resources/html/Footer.html" %>


</body>
</html>
