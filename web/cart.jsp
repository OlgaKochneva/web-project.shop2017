<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page isELIgnored="false" %>

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
    <link rel="stylesheet" href="./main.css" type="text/css">
    <script src="./js/Cart_worker.js"></script>
    <link rel="shortcut icon" href="pics/empt.png" type="image/png">
    <title>Boards only | <fmt:message key="btn_cart"/></title>
</head>

<body style="background-image: url(./pics/bod.png); background-repeat:no-repeat; background-attachment:fixed;">
<div>
    <jsp:include page="header.jsp"/>
</div>
<div style="margin-top: 25px; margin-left: 7px ">

    <c:if test="${empty sessionScope.purchases.purchases}">
        <div style="position: relative; left: 40%;"><img height=300px width=300px src="./pics/empt.png"></div>
    </c:if>

    <c:if test="${not empty sessionScope.purchases.purchases}">
        <table class="tab">
            <thead class="main">
            <td></td>
            <td><fmt:message key="titlesh"/></td>
            <td><fmt:message key="count"/></td>
            <td><fmt:message key="pr2"/></td>
            <td width="30px"></td>
            </thead>
            <c:forEach var="purchase" items="${sessionScope.purchases.purchases}">
                <tr>
                    <td><img height=230px width=220px src="${purchase.imgurl}"></td>
                    <td style=" width: 810px; text-align: left"><b>${purchase.name}</b> - ${purchase.description}</td>
                    <td style="text-align: center">
                                    <span style="float: right">
                                    <a class="myLin" onclick="minus(${purchase.id})">-</a>
                                    <a class="myLin" onclick="plus(${purchase.id})">+</a>
                                    </span>
                            ${purchase.count}</td>
                    <td style="text-align: center">${purchase.totalcost} <fmt:message key="pr"/></td>
                    <td><a onclick="del(${purchase.id})"><img style="width: 40px; margin: 10px" src="./pics/del.png"></a></td>
                </tr>
            </c:forEach>
            <tr style="border-top-color: #fffbf7">
                <td></td>
                <td></td>
                <td id="result" style="text-align: right "><b><fmt:message key="result"/>: </b></td>
                <td>${sessionScope.purchases.totalCost}<fmt:message key="pr"/></td>
                <c:if test="${empty sessionScope.username}">
                    <td><a class=myLin href="<c:url value="/cabinet"/>"><fmt:message key="btn_order"/></a></td>
                </c:if>
                <c:if test="${not empty sessionScope.username}">
                    <td><a class=myLin href="<c:url value="/order"/>" ><fmt:message key="btn_order"/></a></td>
                </c:if>
            </tr>
        </table>
    </c:if>
</div>
</body>
</html>
