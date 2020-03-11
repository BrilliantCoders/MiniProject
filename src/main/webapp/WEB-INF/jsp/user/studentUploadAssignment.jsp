<%--
  Created by IntelliJ IDEA.
  User: Silver
  Date: 2/18/2020
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Upload Assignment</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/css-circular-prog-bar.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/StudentPerformanceDetail.css"/>" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>



</head>
<body class="body">



<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div>

    <div class="row" style="width: 100%;margin-top: 20px">
        <div class="col-md-2 col-lg-2" ></div>
        <div class="col-md-8 col-lg-8 backBox">
            <div class="containerHead">
                Upload Assignment
            </div>
              <br>
                <table border="0" width="100%">
                    <tr>
                    <th >Assignment Name</th>
                    <th >Uploaded on</th>
                    <th >Due Date</th>
                    </tr>
                    <c:forEach var="emp" items="${listDet}" varStatus="status">
                        <tr>
                            <td>${emp.assgnName}</td>
                            <td>${emp.startDate}</td>
                            <td>${emp.endDate}</td>
                        </tr>
                    </c:forEach>
                </table>



            <br><br>
            <form action="${contextPath}/saveFile"  method="post" enctype="multipart/form-data">
                <input type="file" name="file"><br><br>
                <input type="submit" class="btn btn-success" value="Submit">
            </form>

        </div>


    <%@ include file="/resources/html/Footer.html" %>



</body>
</html>