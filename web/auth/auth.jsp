<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@page isELIgnored="false"%>

<c:if test="${empty sessionScope.locale}">
    <fmt:setLocale value="ru"/>
</c:if>

<c:if test="${sessionScope.locale eq 'ru'}">
    <fmt:setLocale value="ru"/>
</c:if>

<c:if test="${sessionScope.locale eq 'en'}">
    <fmt:setLocale value="en"/>
</c:if>

<c:if test="${sessionScope.locale eq 'gr'}">
    <fmt:setLocale value="gr"/>
</c:if>
<fmt:setBundle basename="/lg"/>

<html>
<head>
    <link href="../auth_form.css" rel="stylesheet" type="text/css" media="all">
    <link rel="stylesheet" href="../button_style.css" type="text/css">
    <link rel="shortcut icon" href="../pics/empt.png" type="image/png">
    <title><fmt:message key="aut"/></title>
</head>
<body style="background-image: url(../pics/bod.png); background-repeat:no-repeat; background-attachment:fixed;">
<div>
    <jsp:include page="../header.jsp"/>
    <div id='container'>
        <div id="boxForm">
            <h2 id="title"><fmt:message key="need_login"/></h2>
            <form action="j_security_check" method="post" name="loginForm" class="form-signin">
                <input type="text" name="j_username" placeholder="Login" class="text" size="20"/><br>
                <input type="password" name="j_password" placeholder="Password" class="text" size="20"/><br>
                <button class="OK" type="submit">OK</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>