<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 06-04-2020
  Time: 17:38
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <style>
        .container{

            margin-left: 0%;
            margin-right: 0%;
            padding-left: 20px;
            padding-right: 20px;
            padding-bottom: 30px;
            margin-top: 1px;
            background: white;


        }
    </style>
</head>
<body class="body">

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div  style=" margin-left: 5%;
    margin-right: 5%;
    padding-left: 20px;
    padding-right: 20px;
    padding-bottom: 30px;
    margin-top: 1px;
    background: white;
    box-shadow: 0 3px 3px 0 rgba(0,0,0,0.2);
">


    <div class="containerHead">
        Attendance Record
    </div>

    <br>



    <div style="width: 100%;alignment: center;text-align: center">
        <table>
            <tr>
                <c:forEach var="headerstr" items="${AttendanceHeader}">
                    <th>${headerstr}</th>
                </c:forEach>
                <th>Percentage Attendance</th>
            </tr>
            <c:forEach var="student" items="${AttendanceList}">
                <tr id="${student.rollNo}">
                    <td>${student.regNo}</td>
                    <td style="text-align: center;">${student.rollNo }</td>
                    <c:forEach var="attendance" items="${student.present}">
                        <c:choose>
                            <c:when test="${attendance=='P'}">
                                <td style="text-align: center;color: green"><b>${attendance}</b></td>
                            </c:when>
                            <c:otherwise>
                                <td style="text-align: center;color: darkred"><b>${attendance}</b></td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${student.percent >= 75.0}">
                            <td style="text-align: center;color: green"><b>${student.percent}</b></td>
                        </c:when>
                        <c:otherwise>
                            <td style="text-align: center;color: darkred"><b>${student.percent}</b></td>
                        </c:otherwise>
                    </c:choose>
                </tr>

            </c:forEach>
        </table>

        <br><br>



    </div>

</div>

<%@ include file="/resources/html/Footer.html" %>

</body>
</html>
