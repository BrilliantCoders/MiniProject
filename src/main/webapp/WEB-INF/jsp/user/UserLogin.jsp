
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/DashBoard.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Header.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Footer.css"/>" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <title>UserLogin</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/admin/Header.jsp" %>


<div class="container">
    <div class="containerHead">
        User Login
    </div>
    </br>
    </br>
    </br>
    </br>

    <form action="${contextPath}/submitUserLogin" align="center">
        <table align="center">
            <tr>
                <td>StudentID:</td>
                <td><input type="StudentID" name="StudentID"/> </td>
            </tr>
            <tr>
                <td>
                    </br>
                </td>
            </tr>
            <tr>
                <td> Password:</td>
                <td><input type="StudentPassword" name="StudentPassword"/> </td>
            </tr>
            <tr>
                <td>
                    </br>
                </td>
            </tr>
            <tr>
                <td> </td>
                <td><input type="submit" name="submit" align="center"></td>
            </tr>
        </table>
    </form>
    </br>
    </br>
</div>
<%@ include file="/resources/html/Footer.html" %>
</body>
</html>