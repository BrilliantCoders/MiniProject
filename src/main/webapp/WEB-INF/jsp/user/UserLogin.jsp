
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

    <form action="${contextPath}/user/login" align="center" method="post">
        <c:if test="${param.error != null}">
            <p>
                Invalid username and password.
            </p>
        </c:if>
        <c:if test="${param.logout != null}">
            <p>
                You have been logged out.
            </p>
        </c:if>




        <table align="center">
            <tr>
                <td>Reg. No.:</td>
                <td><input type="username" name="username"/> </td>
            </tr>
            <tr>
                <td>
                    </br>
                </td>
            </tr>
            <tr>
                <td> Password:</td>
                <td><input type="password" name="password"/> </td>
            </tr>
            <tr>
                <td>
                    </br>
                </td>
            </tr>
            <tr>
                <td><input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>   </td>
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