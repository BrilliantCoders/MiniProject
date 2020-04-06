<%--
  Created by IntelliJ IDEA.
  User: Rajat
  Date: 28-01-2020
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="body">

<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">

    <div class="containerHead">
        DashBoard
    </div>

    <div style="width: 100%;alignment: center;text-align: center">
        <form:form action="${contextPath}/uploadCourse" modelAttribute="course"  method="post" enctype="multipart/form-data">
            <table cellpadding="12px" cellspacing="3px" align="center" style="color: black">
                <tr>
                    <td>Course Name </td>
                    <td><form:input path="courseName"/></td>
                    <td>(E.g. Btech or MCA or MBA ...)</td>
                </tr>
                <tr>
                    <td>Branch Name </td>
                    <td><form:input path="branchName"/></td>
                    <td>(E.g. CS,IT,EC,...  Fill NA if not applicable)</td>
                </tr>
                <tr>
                    <td>Semester </td>
                    <td><form:input path="semester" /></td>
                    <td>(Enter Number like 1 or 2 or 3 ...)</td>
                </tr>
                <tr>
                    <td>Subject Name</td>
                    <td><form:input path="subName"/></td>
                </tr>
                <tr>
                    <td>Type</td>
                    <td>
                        <form:select path="type">
                            <form:option value="0">Class</form:option>
                            <form:option value="1">Lab</form:option>
                            <form:option value="2">Class and Lab both</form:option>
                        </form:select>
                    </td>

                </tr>
                <tr>
                    <td>Current Year</td>
                    <td><form:input path="year"/></td>
                </tr>
                <tr>
                    <td>Upload File</td>
                    <td><input type="file" name="file"></td>
                </tr>

            </table>
            <br>
            <input type="submit" value="Submit" class="btn btn-success">



        </form:form>

    </div>
</div>

<%@ include file="/resources/html/Footer.html" %>


</body>
</html>
