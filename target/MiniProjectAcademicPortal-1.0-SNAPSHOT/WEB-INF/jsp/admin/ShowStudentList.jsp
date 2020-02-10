<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 25-01-2020
  Time: 18:14
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
        <b>Take Attendance Manually</b>
    </div>

    <form action="${contextPath}/submitAttendance"  method="post">
        <input type="hidden" id="absent1" name="absent" value="">
        <input type="submit" class="btn btn-success" value="Submit Attendance">
    </form>

    <div style="width: 97%;alignment: center;text-align: center;horiz-align: center;margin: 10px">
         <table>
             <tr>
                 <th>Roll No</th>
                 <th>Name</th>
                 <th>Reg. No.</th>
                 <th>P/A</th>
             </tr>
             <c:forEach var="student" items="${Students}">
                 <tr id="tr${student.regNo}">
                     <td>${student.rollNo}</td>
                     <td>${student.name}</td>
                     <td>${student.regNo}</td>
                     <td>
                         <input type="checkbox"  index="${student.rollNo}" id="${student.regNo}"  name="checkbox${student.regNo}">
                     </td>
                 </tr>

             </c:forEach>
         </table>

     </div>

     <form action="${contextPath}/submitAttendance" id="form" method="post">
         <input type="hidden" id="absent" name="absent" value="">
         <input type="submit" class="btn btn-success" value="Submit Attendance">
     </form>


</div>

<%@ include file="/resources/html/Footer.html" %>



</body>
</html>
