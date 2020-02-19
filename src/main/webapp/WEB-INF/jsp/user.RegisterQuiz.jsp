<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 18-02-2020
  Time: 22:08
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
        <b>Quizzes</b>
    </div>



    <div style="width: 97%;alignment: center;text-align: center;horiz-align: center;margin: 10px">
        <table>
            <tr style="text-align: center">
                <th>Sr. No.</th>
                <th>Quiz Name</th>
                <th>Start Date & Time</th>
                <th>End Date & Time</th>
                <th>Duration</th>
                <th>Enter</th>
            </tr>
            <c:forEach var="quiz" items="${quizList}">
                <tr id="tr${quiz.id}" style="text-align: center">
                    <td>${quiz.id}</td>
                    <td>${quiz.quizName}</td>
                    <td>${quiz.startDateTime}</td>
                    <td>${quiz.endDateTime}</td>
                    <td>${quiz.duration}</td>
                    <td style="color: #0d9e08;">
                    <c:if test="${quiz.active == 1}">
                        <form action="${contextPath}/showQuestions" method="post">
                            <input type="hidden" name="duration" value="${quiz.duration}">
                            <input type="hidden" name="quizId" value="${quiz.id}">
                            <input type="submit" value="Enter">
                        </form>
                    </c:if>
                    </td>
                </tr>

            </c:forEach>
        </table>

    </div>




</div>

<%@ include file="/resources/html/Footer.html" %>



</body>
</html>
