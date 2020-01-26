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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/ShowStudentList.css"/>" />

</head>
<body>

     <div style="width: 50%;alignment: center;text-align: center">
         <table>
             <tr>
                 <th>Roll No</th>
                 <th>Name</th>
                 <th>Reg. No.</th>
                 <th>P/A</th>
             </tr>
             <c:forEach var="student" items="${Students}">
                 <tr>
                     <td>${student.rollNo}</td>
                     <td>${student.name}</td>
                     <td>${student.regNo}</td>
                     <td>
                         <input type="checkbox" name="${student.regNo}">
                     </td>
                 </tr>

             </c:forEach>
         </table>

     </div>

</body>
</html>
