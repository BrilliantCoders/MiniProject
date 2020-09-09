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
    <title>Quiz Result</title>
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
        Quiz Result
    </div>

   <br>




<div style="width: 100%;alignment: center;text-align: center">
    <table>
        <tr>

            <th>Roll No.</th>
            <th>Name</th>
            <th>Percentage Marks</th>

        </tr>
        <c:forEach var="quizResult" items="${QuizResult}">
            <tr id="${quizResult.rollNo}">
                <td>${quizResult.rollNo}</td>
                <td>${quizResult.name}</td>
                <td>${quizResult.marks} %</td>
            </tr>

        </c:forEach>
    </table>

    <br><br>



</div>

</div>

<%@ include file="/resources/html/Footer.html" %>

</body>
</html>
