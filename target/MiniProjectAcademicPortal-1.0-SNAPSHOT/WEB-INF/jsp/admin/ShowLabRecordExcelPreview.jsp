<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 18-03-2020
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Lab Record</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ShowStudentList.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body class="body">

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div  style=" margin-left: 5%;
    margin-right: 5%;
    padding-left: 20px;
    padding-right: 20px;
    padding-bottom: 30px;
    margin-top: 1px;
    background: white;
    box-shadow: 0 3px 3px 0 rgba(0,0,0,0.2);
">

    <div class="containerHead">
        Preview LabMarks
    </div>

    <br>
    <div>
        <form action="${contextPath}/admin/submitLabRecordViaFile">
            <input type="submit" class="btn btn-success" value="Submit Marks">
        </form>
    </div>



    <div style="width: 100%;alignment: center;text-align: center">
        <table>
            <tr>
                <c:forEach var="headerstr" items="${LabMarksHeader}">
                    <th>${headerstr}</th>
                </c:forEach>
            </tr>
            <c:forEach var="studentlabMarks" items="${LabMarksList}">
                <tr id="${studentlabMarks.rollNo}">
                    <td>${studentlabMarks.rollNo}</td>
                    <td>${studentlabMarks.name}</td>
                    <c:forEach var="mark" items="${studentlabMarks.executionMarks}">
                        <c:choose>
                            <c:when test="${mark >= 50.0}">
                                <td style="text-align: center;color: green"><b>${mark}</b></td>
                            </c:when>
                            <c:otherwise>
                                <td style="text-align: center;color: darkred"><b>${mark}</b></td>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </tr>

            </c:forEach>
        </table>

        <br><br>



    </div>
    <div>
        <form action="${contextPath}/admin/submitLabRecordViaFile">
            <input type="submit" class="btn btn-success" value="Submit Marks">
        </form>
    </div>
</div>

<%@ include file="/resources/html/Footer.html" %>

</body>
</html>

