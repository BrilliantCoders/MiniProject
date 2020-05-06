<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 07-02-2020
  Time: 23:26
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
        .question{
            background: #dddddd;
            font-weight: bold;
            padding: 8px;
            white-space: pre-wrap;
            word-wrap: break-word
        }
        .answer{
            color: #0d9e08;
            font-weight: bold;
        }
        .invalid{
            color: red;
            font-weight: bold;

        }
    </style>


</head>
<body class="body">

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">

    <div class="containerHead">
        Preview Quiz Questions
    </div>

    <br>

    <div class="invalid">
        <c:if test="${invalid != \"\"}">
            Question ${invalid} are invalid.
        </c:if>

    </div>
    <br>
    <div>
        <form action="${contextPath}/admin/submitQuiz">
            <input type="submit" class="btn btn-success" value="Submit Quiz">
        </form>
    </div>



    <div style="width: 100%;">
        <ol>
            <c:forEach var="question" items="${questionList}">
                 <li>
                     <div >
                         <pre class="question">${question.question}</pre>
                     </div>
                     <div class="option">
                         1.) ${question.option1}
                     </div>
                     <div class="option">
                         2.) ${question.option2}
                     </div>
                     <div class="option">
                         3.) ${question.option3}
                     </div>
                     <div class="option">
                         4.) ${question.option4}
                     </div>
                     <div class="answer">
                         Answer - ${question.answer}
                     </div>
                     <br><br>
                 </li>
            </c:forEach>
        </ol>
        <br><br>



    </div>
    <div>
        <form action="${contextPath}/admin/submitQuiz">
            <input type="submit" class="btn btn-success" value="Submit Quiz">
        </form>
    </div>
</div>

<%@ include file="/resources/html/Footer.html" %>

</body>
</html>
