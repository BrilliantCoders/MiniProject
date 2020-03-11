<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 19-02-2020
  Time: 22:48
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
            background: #f2f2f2;
            color: black;
            white-space: pre-wrap;
            font-weight: bold;
            word-wrap: break-word;
            padding: 8px;
        }
        .correct{
            background: #f2f2f2;
            color: green;
            white-space: pre-wrap;
            font-weight: bold;
            word-wrap: break-word;
            padding: 8px;
        }


        .answer{
            color: #0d9e08;
            font-weight: bold;
        }
        .invalid{
            background: #f2f2f2;
            color: red;
            font-weight: bold;
            word-wrap: break-word;
            white-space: pre-wrap;
            padding: 8px;
        }
    </style>


</head>
<body class="body">

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">

    <div class="containerHead">
        My Response
    </div>

    <br>


    <br>



    <div style="width: 100%;">
        <ol>
            <c:forEach var="question" items="${questionList}">
                <li>
                    <c:choose>
                    <c:when  test="${question.answer == question.userAnswer}">
                        <div >
                            <pre class="correct">${question.question}</pre>
                        </div>
                    </c:when>
                        <c:when  test="${question.userAnswer == -1}">
                            <div >
                                <pre class="question">${question.question}</pre>
                            </div>
                        </c:when>
                        <c:otherwise>
                        <div>
                            <pre class="invalid">${question.question}</pre>
                        </div>
                    </c:otherwise>
                    </c:choose>
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
                    <div>
                        <c:choose>
                            <c:when test="${question.userAnswer == -1}">
                                Your Answer - None
                            </c:when>
                            <c:otherwise>
                                Your Answer - ${question.userAnswer}
                            </c:otherwise>
                        </c:choose>

                    </div>
                    <div>
                        Explanation - ${question.expanation}
                    </div>
                    <br><br>
                </li>
            </c:forEach>
        </ol>
        <br><br>



    </div>

</div>

<%@ include file="/resources/html/Footer.html" %>

</body>
</html>
