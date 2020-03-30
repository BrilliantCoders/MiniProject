<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 19-02-2020
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <style>
        .question{
            background: #dddddd;
            font-weight: bold;
            padding: 8px;
        }
    </style>






</head>
<body class="body">

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">

    <div class="containerHead">
        Result
    </div>
    <br>
    <table cellpadding="10px" style="color: black">
        <tr>
            <td style="color: black">
                Right :
            </td>
            <td>
                <label id="right" style="color: #0d9e08;font-weight: bold"></label>
            </td>
        </tr>

        <tr>
            <td style="color: black">
                Wrong :
            </td>
            <td>
                <label id="wrong" style="color: Red;font-weight: bold"></label>
            </td>
        </tr>


        <tr>
            <td style="color: black">
                Unattempted :
            </td>
            <td>
                <label id="unattempted" style="color: #3d3395;font-weight: bold"></label>
            </td>
        </tr>
        <br><br>

        <tr>
            <td>
                <label style="font-size: 22px;color: black"> Total Marks :</label>
            </td>
            <td>
                <label id="total" style="color: black;font-weight: bold;font-size: 21px"></label>
            </td>
        </tr>
    </table>
    <form action="${contextPath}/showResponses" method="post">
        <input type="submit" class="btn btn-success" value="Show My Responses">
    </form>

    <script>


        var correct=0;
        var wrong=0;
        var unattempted=0;
        <c:forEach var="question" items="${questionList}">
        var ans=${question.userAnswer};
        if(ans == ${question.answer}){

            correct++;
        }
        else if(ans != -1){
            wrong++;
        }
        else {
            unattempted++;
        }
        </c:forEach>
        var c=correct+"  (Marks = "+correct*4+")";

        $('#right').html(c);
        $('#wrong').html(wrong+"  (Marks = "+wrong*-1+")");
        $('#unattempted').html(unattempted+"  (Marks = "+unattempted*0+")");
        var total=(correct*4)+(wrong*-1);
        var out=(correct+wrong+unattempted)*4;
        $('#total').html(" ( "+total+" / "+out+" )");


    </script>



</div>

<%@ include file="/resources/html/Footer.html" %>

</body>
</html>
