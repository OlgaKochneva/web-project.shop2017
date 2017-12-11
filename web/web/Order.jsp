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
    <link rel="stylesheet" href="./auth_form.css" type="text/css">
    <link rel="shortcut icon" href="pics/empt.png" type="image/png">
    <script src="./js/map.js"></script>
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript">
    </script>


    <title><fmt:message key="btn_doorder"/></title>
</head>

<body onload="initMap()"
      style="background-image: url(./pics/bod.png); background-repeat:no-repeat; background-attachment:fixed;">
<div>
    <jsp:include page="header.jsp"/>
    <div style="text-align: center">
        <form method="post" action="./order" class="order_form">
            <div style="color: white; font-style: italic; font-size: 20px">
                <span><div style="display: inline-block">
                <fmt:message key="Delivery"/>
                    <input id="type-choice" name="type-choice" type="checkbox" onchange="changeType()">
                         </div></span>

                <div id="shop" style="margin-top: 5px">
                    <fmt:message key="ShopChoice"/><br>
                    <select style="margin-top: 5px" name="shop-choice" id="shop-choice" onchange="changeShop()">
                        <option value="1"><fmt:message key="Address2" /></option>
                        <option value="2" selected><fmt:message key="Address1" /></option>
                    </select>
                </div>
                <div id="courier" style="display:none">
                    <fmt:message key="Addresse"/><br>
                    <input class="a_input" name="addressee" id="addressee" type="text" >
                </div>
                <input class="OK" type="submit"  value="<fmt:message key="btn_doorder" />">
            </div>
        </form>
        <div id="map"></div>
    </div>
</div>
</body>
</html>
