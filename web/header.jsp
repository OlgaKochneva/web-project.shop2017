<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String lang = (String) request.getSession().getAttribute("locale");


    Locale locale;
    if ("en".equals(lang)) {
        locale = new Locale("en", "en");
    } else if ("kz".equals(lang)) {
        locale = new Locale("gr", "gr");
    } else if ("ru".equals(lang)) {
        locale = new Locale("ru", "ru");
    } else {
        locale = Locale.getDefault();
    }
    ResourceBundle res = ResourceBundle.getBundle("lg", locale);
%>

<div class='header'>
    <div>

        <div style="float:left">
            <button class="toptab"><i>История</i></button>
            <button class="toptab"><i>Корзина</i></button>
            <button class="toptab"><i>Вход</i></button>
    </div>
        <div style="float:right">
            <a href="?lang=ru" class="buttn_lng"><i>Ru</i></a>
            <a href="?lang=en" class="buttn_lng"><i>En</i></a>
            <a href="?lang=gr" class="buttn_lng"><i>Ge</i></a>
        </div>


</div>
