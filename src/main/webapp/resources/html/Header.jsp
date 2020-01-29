<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 27-01-2020
  Time: 00:49
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

<div class="column1">
    <img width="65px" height="75px" src="<c:url value="/resources/image/logo.png"/>">
</div>
<div class="column2">
    <span class="name"> Er. Manoj Wairya</span><br>
    <span style="color: black">An Academic portal to assist students for their studies</span><br>
    <span style="color: black">CSED MNNIT Allahabad , Prayagraj</span>

</div>
<div class="column3">
    <b><span style="color: #3d3395;"> Contact No. </span></b> <label style="color: black">- 9876543210</label>
    <br>
    <span style="color: #3d3395;"><b>Email </b></span>  <label style="color: black"> - test132@xyz.com </label>
</div>


</body>
</html>
