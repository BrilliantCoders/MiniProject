<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 06-04-2020
  Time: 16:10
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
        <b>Students Not Visited</b>
    </div>



    <div style="width: 97%;alignment: center;text-align: center;horiz-align: center;margin: 10px">
        <table>
            <tr style="text-align: center">
                <th>Roll No</th>
                <th>Name</th>

            </tr>
            <c:forEach var="student" items="${Students}">
                <tr>
                    <td style="text-align: center">${student.rollNo}</td>
                    <td>${student.name}</td>
                </tr>

            </c:forEach>
        </table>

    </div>

</div>

<%@ include file="/resources/html/Footer.html" %>



</body>
</html>
