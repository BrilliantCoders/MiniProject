<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 06-02-2020
  Time: 01:57
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
    <script>
        var absentList=[];
        $('document').ready(function(){

            $('input:checkbox').prop('checked', false);

            $('input[name*="checkbox"]').change(function()
            {
                var id=$(this).attr("id");
                if ($(this).is(':checked')) {
                    absentList.push(id);
                }
                else{
                    var index=absentList.indexOf(id);
                    absentList.splice(index,1);
                }
                $('#tr'+id).toggleClass("absent");
            });

            $("form").submit(function() {
                alert("submit");
                var x=absentList.join(",");
                $("#absent").val(x);
                $("#absent1").val(x);
            });

        });
    </script>

</head>
<body class="body">



<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">



    <div class="containerHead">
        <b>Assignments</b>
    </div>



    <div style="width: 97%;alignment: center;text-align: center;horiz-align: center;margin: 10px">
        <table>
            <tr style="text-align: center">
                <th>Sr. No.</th>
                <th>Assignment Name</th>
                <th>Start Date</th>
                <th>Last Date</th>
                <th>Late Submission Allowed</th>
            </tr>
            <c:forEach var="assgn" items="${assgnList}">
                <tr id="tr${assgn.id}" style="text-align: center">
                    <td >${assgn.id}</td>
                    <td>${assgn.assgnName}</td>
                    <td>${assgn.startDate}</td>
                    <td>${assgn.endDate}</td>
                    <td>${assgn.lateSub}</td>
                </tr>

            </c:forEach>
        </table>

    </div>




</div>

<%@ include file="/resources/html/Footer.html" %>



</body>
</html>
