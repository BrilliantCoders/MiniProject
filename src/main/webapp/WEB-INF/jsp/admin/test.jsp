<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 23-01-2020
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form action="${contextPath}/admin/login" method="post">
       <input type="text" name="username">
       <input type="text" name="password">
       <input type="submit" value="Submit">
   </form>

</body>
</html>
