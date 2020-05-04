<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 11-03-2020
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Upload Notice</title>
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
                Upload Notice
            </div>
            <div>

                <form action="${contextPath}/uploadNotice" method="post"  >
                    <div style="text-align: center;width: 100%;">
                        <table cellpadding="9px" align="center">
                            <tr>
                                <td>Name</td>
                                <td><input type="text" name="name"/></td>
                            </tr>
                            <tr>
                                <td>Description</td>
                                <td><textarea name="desc"></textarea></td>
                            </tr>

                        </table>
                        <br>
                        <input type="submit" value="Submit" class="btn btn-success">
                    </div> 
                </form>

            </div>
        </div>
        <div class="col-md-2 col-lg-2" ></div>

    </div>
</div>





<%@ include file="/resources/html/Footer.html" %>



</body>
</html>
