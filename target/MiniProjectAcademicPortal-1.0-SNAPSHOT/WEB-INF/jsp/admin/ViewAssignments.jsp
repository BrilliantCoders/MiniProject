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

    <style>
        .body{
            background: #e1e1e1;
            display:flex;
            flex-direction:column;
            font-size: 16px;
            padding: 0px;
            height: 100%;
            margin: 0px;
            alignment: center;

        }

        .container{

            margin-left: 15%;
            margin-right: 15%;
            padding-left: 15px;
            padding-right: 15px;
            padding-top: 15px;
            padding-bottom: 15px;
            margin-top: 1px;
            margin-bottom: 13px;
            background: #ffffff;
            box-shadow: 0 1px 1px 0 rgba(0,0,0,0.2);

        }

        .containerHead{

            padding-top: 10px;
            padding-bottom: 10px;
            font-size: 23px;
            background: white;


        }

    </style>
</head>


<body class="body">


<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>

<div >

    <div class="container containerHead">
        All Assignment
    </div>




    <div style="width: 100%;alignment: center;text-align: left">

        <c:forEach var="assgn" items="${assgnList}">
            <div class="row container">
                <div class="col-lg-10 col-md-10"  id="${assgn.id}">
                    <div style="color: #3d3395;font-size: 18px"><b>${assgn.assgnName}</b></div>
                        Start Date - ${assgn.startDate}<br>
                        End Date - ${assgn.endDate}<br>
                        Late Submission - ${assgn.lateSub}<br>

                </div>
                <div class="col-lg-2 col-md-2">
                    <a href="${contextPath}/admin/deleteAssignment/${assgn.id}">
                        <div>
                            <img height="27px" width="27px" src="<c:url value="/resources/image/delete.png" />">
                            <span>Remove</span></div>
                    </a>
                    <br>
                    <a href="${contextPath}/admin/showAssignmentVisitedStudents/${assgn.id}">
                        <div>
                            <span>Submissions</span></div>
                    </a>
                </div>
            </div>

        </c:forEach>


    </div>



</div>

<%@ include file="/resources/html/Footer.html" %>



</body>
</html>
