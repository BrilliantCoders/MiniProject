<%@ page import="java.util.List" %>
<%@ page import="com.model.Question" %><%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 18-02-2020
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        }
    </style>


    <script>
        $('document').ready(function(){

            $("#submitQuiz").submit(function() {
                alert("submit");
                var correct=0;
                var wrong=0;
                var unattempted=0;
                <c:forEach var="question" items="${questionList}">
                var ans=$('input[name="${question.id}"]:checked').val();
                if(ans == ${question.answer}){

                    correct++;
                }
                else if(ans != undefined){
                    wrong++;
                }
                else {
                    unattempted++;
                }
                </c:forEach>
                alert(correct+' '+wrong+' '+unattempted);
            });

        });
    </script>

    <script>

        function submit() {


        }



        function dateAdd(date, interval, units) {
            if(!(date instanceof Date))
                return undefined;
            var ret = new Date(date); //don't change original date
            var checkRollover = function() { if(ret.getDate() != date.getDate()) ret.setDate(0);};
            switch(String(interval).toLowerCase()) {
                case 'year'   :  ret.setFullYear(ret.getFullYear() + units); checkRollover();  break;
                case 'quarter':  ret.setMonth(ret.getMonth() + 3*units); checkRollover();  break;
                case 'month'  :  ret.setMonth(ret.getMonth() + units); checkRollover();  break;
                case 'week'   :  ret.setDate(ret.getDate() + 7*units);  break;
                case 'day'    :  ret.setDate(ret.getDate() + units);  break;
                case 'hour'   :  ret.setTime(ret.getTime() + units*3600000);  break;
                case 'minute' :  ret.setTime(ret.getTime() + units*60000);  break;
                case 'second' :  ret.setTime(ret.getTime() + units*1000);  break;
                default       :  ret = undefined;  break;
            }
            return ret;
        }

        // Update the count down every 1 second
        // Find the distance between now and the count down date
        var oldDateObj = new Date();

        var d=${duration}

        var newDateObj = dateAdd(oldDateObj,'minute',d).getTime();


        var x = setInterval(function() {

            var date = new Date().getTime();

            var distance = newDateObj-date;

            // Time calculations for days, hours, minutes and seconds
            var days = Math.floor(distance / (1000 * 60 * 60 * 24));
            var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
            var seconds = Math.floor((distance % (1000 * 60)) / 1000);

            // Display the result in the element with id="demo"
            document.getElementById("demo").innerHTML = days + "d " + hours + "h "
                + minutes + "m " + seconds + "s ";

            // If the count down is finished, write some text
            if (distance < 0) {
                clearInterval(x);
                document.getElementById("demo").innerHTML = "EXPIRED";
            }
            distance-=1000;
        }, 1000);
    </script>


</head>
<body class="body">

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">

    <div id="demo" style="color: red;size: 25px">

    </div>

    <br>


    <br>
    <button onclick="submit()" value="Sub">Submit Question</button><br>
    <div>


        <form action="${contextPath}/submitQuiz" id="submitQuiz">
            <input type="submit" class="btn btn-success" value="Submit Quiz">
        </form>
    </div>



    <div style="width: 100%;">
        <ol>
            <c:forEach var="question" items="${questionList}">
                <li>
                    <div class="question">
                        <pre>${question.question}</pre>
                    </div>



                    <div class="option">
                       <input type="radio" value="1" name="${question.id}"> 1.) ${question.option1}
                    </div>
                    <div class="option">
                        <input type="radio" value="2" name="${question.id}"> 2.) ${question.option2}
                    </div>
                    <div class="option">
                        <input type="radio" value="3" name="${question.id}"> 3.) ${question.option3}
                    </div>
                    <div class="option">
                        <input type="radio" value="4" name="${question.id}"> 4.) ${question.option4}
                    </div>

                    <br><br>
                </li>
            </c:forEach>
        </ol>
        <br><br>



    </div>
    <div>
        <form action="${contextPath}/submitQuiz">
            <input type="submit" class="btn btn-success" value="Submit Quiz">
        </form>
    </div>
</div>

<%@ include file="/resources/html/Footer.html" %>

</body>
</html>
