<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 30-01-2020
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>DashBoard</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/DashBoard.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/css-circular-prog-bar.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/StudentPerformanceDetail.css"/>" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>



</head>
<body class="body">



<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div>

    <div class="row" style="width: 100%;margin-top: 10px">
        <div class="col-md-2 col-lg-2" ></div>
        <div class="col-md-8 col-lg-8 backBox">
            <div>
                Personal Details

            </div>
            <div class="row" style="width: 100%;margin-top: 10px">
                <div class="col-md-2 col-lg-2 " style="alignment: center;text-align: center">
                    <img height="150px" width="80%" src="<c:url value="/resources/image/logo.png"/>"/>
                </div>
                <div class="col-md-7 col-lg-7 ">
                    <table cellpadding="5px">
                        <tr>
                            <td>Name</td>
                            <td>Rajat</td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td>Rajat</td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td>Rajat</td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td>Rajat</td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td>Rajat</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-2 col-lg-2"></div>
    </div>


    <div class="row" style="width: 100%;margin-top: 10px" >
        <div class="col-md-2 col-lg-2" ></div>
        <div class="col-md-8 col-lg-8 backBox" >
            Performance
            <div class="row" style="width: 100%">
                <div class="col-md-2 col-lg-2" >
                    <div class="progress-circle over50 p80">
                        <span>80%</span>
                        <div class="left-half-clipper">
                            <div class="first50-bar"></div>
                            <div class="value-bar"></div>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <b>Attendance</b>
                    </div>
                </div>
                <div class="col-md-2 col-lg-2" >
                    <div class="progress-circle over50 p80">
                        <span>10%</span>
                        <div class="left-half-clipper">
                            <div class="first50-bar"></div>
                            <div class="value-bar"></div>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <b>Quiz</b>
                    </div>
                </div>
                <div class="col-md-2 col-lg-2" >
                    <div class="progress-circle over50 p80">
                        <span>10%</span>
                        <div class="left-half-clipper">
                            <div class="first50-bar"></div>
                            <div class="value-bar"></div>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <b>Assignment</b>
                    </div>
                </div>
                <div class="col-md-2 col-lg-2" >
                    <div class="progress-circle over50 p80">
                        <span>10%</span>
                        <div class="left-half-clipper">
                            <div class="first50-bar"></div>
                            <div class="value-bar"></div>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <b>Mid Sem</b>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-2 col-lg-2" ></div>
    </div>

</div>



<%@ include file="/resources/html/Footer.html" %>




</body>
</html>
