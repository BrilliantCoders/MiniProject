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
    <style>
        th,td{
            border: 0.5px solid #ddd;
            padding: 8px;
            word-wrap:break-word
        }
        table{

        }

    </style>


</head>
<body class="body">



<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div>

    <div class="row" style="width: 100%;margin-top: 10px">
        <div class="col-md-1 col-lg-1" ></div>
        <div class="col-md-10 col-lg-10 backBox">
            <div>
                Personal Details

            </div>
            <div class="row" style="width: 100%;margin-top: 10px">

                <div class="col-md-7 col-lg-7 ">
                    <table cellpadding="5px">
                        <tr>
                            <td style="font-weight: bold">Name</td>
                            <td>${Student.name}</td>
                        </tr>
                        <tr>
                            <td style="font-weight: bold">Reg. No.</td>
                            <td>${Student.regNo}</td>
                        </tr>
                        <tr>
                            <td style="font-weight: bold">Roll No.</td>
                            <td>${Student.rollNo}</td>
                        </tr>
                        <tr>
                            <td style="font-weight: bold">Email</td>
                            <td>${Student.email}</td>
                        </tr>
                        <tr>
                            <td style="font-weight: bold">Last Visit</td>
                            <td>${Student.latVisit}</td>
                        </tr>

                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-1 col-lg-1"></div>
    </div>


<%--    <div class="row" style="width: 100%;margin-top: 10px" >--%>
<%--        <div class="col-md-2 col-lg-2" ></div>--%>
<%--        <div class="col-md-8 col-lg-8 backBox" >--%>
<%--            Performance--%>
<%--            <div class="row" style="width: 100%">--%>
<%--                <div class="col-md-2 col-lg-2" >--%>
<%--                    <div class="progress-circle over50 p80">--%>
<%--                        <span>80%</span>--%>
<%--                        <div class="left-half-clipper">--%>
<%--                            <div class="first50-bar"></div>--%>
<%--                            <div class="value-bar"></div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div style="text-align: center">--%>
<%--                        <b>Attendance</b>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-md-2 col-lg-2" >--%>
<%--                    <div class="progress-circle over50 p80">--%>
<%--                        <span>10%</span>--%>
<%--                        <div class="left-half-clipper">--%>
<%--                            <div class="first50-bar"></div>--%>
<%--                            <div class="value-bar"></div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div style="text-align: center">--%>
<%--                        <b>Quiz</b>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-md-2 col-lg-2" >--%>
<%--                    <div class="progress-circle over50 p80">--%>
<%--                        <span>10%</span>--%>
<%--                        <div class="left-half-clipper">--%>
<%--                            <div class="first50-bar"></div>--%>
<%--                            <div class="value-bar"></div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div style="text-align: center">--%>
<%--                        <b>Assignment</b>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-md-2 col-lg-2" >--%>
<%--                    <div class="progress-circle over50 p80" style="text-align: left">--%>
<%--                        <span>10%</span>--%>
<%--                        <div class="left-half-clipper">--%>
<%--                            <div class="first50-bar"></div>--%>
<%--                            <div class="value-bar"></div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div style="text-align: left">--%>
<%--                        <b>Mid Sem</b>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-md-2 col-lg-2" ></div>--%>
<%--    </div>--%>

    <div class="row" style="width: 100%;margin-top: 10px" >
        <div class="col-md-1 col-lg-1" ></div>
        <div class="col-md-10 col-lg-10 backBox" >
            Attendance
            <div style="alignment: center; margin-top: 10px;text-align: center">
                <table width="100%" cellpadding="5px" cellspacing="5px" style="display: block;
            max-width: 100%;
            overflow: scroll;">
                    <tr>
                        <c:forEach var="headerstr" items="${AttendanceHeader}">
                            <th>${headerstr}</th>
                        </c:forEach>
                        <th>Percentage Attendance</th>
                    </tr>
                    <c:forEach var="student" items="${AttendanceList}">
                        <tr id="${student.rollNo}">
                            <td>${student.regNo}</td>
                            <td >${student.rollNo }</td>
                            <c:forEach var="attendance" items="${student.present}">
                                <c:choose>
                                    <c:when test="${attendance=='P'}">
                                        <td style="color: green;text-align: center"><b>${attendance}</b></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td style="color: darkred;text-align: center"><b>${attendance}</b></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${student.percent >= 75.0}">
                                    <td style="color: green; text-align: center"><b>${student.percent}</b></td>
                                </c:when>
                                <c:otherwise>
                                    <td style="color: darkred;text-align: center"><b>${student.percent}</b></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>

                    </c:forEach>
                </table>

                <br>



            </div>
        </div>
        <div class="col-md-1 col-lg-1" ></div>
    </div>

    <div class="row" style="width: 100%;margin-top: 10px" >
        <div class="col-md-1 col-lg-1" ></div>
        <div class="col-md-10 col-lg-10 backBox" >
            Quiz Results
            <div style="width: 100%;alignment: center; margin-top: 10px;text-align: center">
                <table width="80%" cellpadding="5px">
                    <tr>

                        <c:forEach var="headerstr" items="${QuizResult}" varStatus="loop">
                            <th>Quiz ${loop.index+1}</th>
                        </c:forEach>
                    </tr>
                    <tr>
                    <c:forEach var="marks" items="${QuizResult}">
                        <c:choose>
                            <c:when test="${marks == -1000}">
                                <td>N/A</td>
                            </c:when>
                            <c:otherwise>
                                <td>${marks}%</td>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                    </tr>
                </table>

                <br>



            </div>
        </div>
        <div class="col-md-1 col-lg-1" ></div>
    </div>


</div>



<%@ include file="/resources/html/Footer.html" %>




</body>
</html>
