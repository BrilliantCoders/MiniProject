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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        var absentList=[];
        $('document').ready(function(){
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

            $("#form").submit(function() {
                alert("submit");
                $("#absent").val(absentList.join(","));
            });

        });
    </script>

</head>
<body>



<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">

    <div class="containerHead">
        Students List
    </div>


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
                         <input type="checkbox" index="${student.rollNo}" id="${student.regNo}"  name="checkbox${student.regNo}">
                     </td>
                 </tr>

             </c:forEach>
         </table>

     </div>

     <form action="${contextPath}/submitAttendance" id="form" method="post">
         <input type="hidden" id="absent" name="absent" value="">
         <input type="submit" value="Submit Attendance">
     </form>

     <form action="${contextPath}/saveFile"  method="post" enctype="multipart/form-data">
         <input type="file" name="file">
         <input type="submit" value="Submit">
     </form>

</div>

<%@ include file="/resources/html/Footer.html" %>



</body>
</html>