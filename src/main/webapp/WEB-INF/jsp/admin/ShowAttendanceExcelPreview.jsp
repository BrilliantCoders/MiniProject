<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 27-01-2020
  Time: 01:22
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
</head>
<body class="body">

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">

    <div class="containerHead">
        Preview Attendance
    </div>

   <br>
    <div>
        <form action="${contextPath}/admin/submitAttendanceViaFile">
            <input type="submit" class="btn btn-success" value="Submit Attendance">
        </form>
    </div>



<div style="width: 100%;alignment: center;text-align: center">
    <table>
        <tr>
            <c:forEach var="headerstr" items="${AttendanceHeader}">
                <th>${headerstr}</th>
            </c:forEach>
        </tr>
        <c:forEach var="student" items="${AttendanceList}">
            <tr id="${student.rollNo}">
                <td>${student.rollNo}</td>
                <td>${student.name}</td>
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
            </tr>

        </c:forEach>
    </table>

    <br><br>



</div>
    <div>
        <form action="${contextPath}/admin/submitAttendanceViaFile">
            <input type="submit" class="btn btn-success" value="Submit Attendance">
        </form>
    </div>
</div>

<%@ include file="/resources/html/Footer.html" %>

</body>
</html>
