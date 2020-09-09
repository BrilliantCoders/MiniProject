<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 26-04-2020
  Time: 23:32
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

    <div class="container containerHead"align="center">
         Teaching Material
    </div>




    <div style="width: 100%;alignment: center;text-align: left">

        <c:forEach var="teachingMaterial" items="${listDet}">
            <div class="container">
                <div class="row ">
                    <div class="col-lg-10 col-md-10"  id="${teachingMaterial.id}">
                        <div style="color: #3d3395;font-size: 18px";align="center"><b>${teachingMaterial.name}</b></div>
                            ${teachingMaterial.description}<br>
                            <a href="${contextPath}/${teachingMaterial.file}">${teachingMaterial.file}</a>
                    </div>
                    <div class="col-lg-2 col-md-2">
                        Date - ${teachingMaterial.date}<br><br>
                        <br>

                    </div>
                </div>
            </div>

        </c:forEach>


    </div>



</div>

<%@ include file="/resources/html/Footer.html" %>


</body>
</html>

