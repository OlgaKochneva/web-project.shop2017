<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String lang = (String) request.getSession().getAttribute("locale");


    Locale locale;
    if ("en".equals(lang)) {
        locale = new Locale("en", "en");
    } else if ("gr".equals(lang)) {
        locale = new Locale("gr", "gr");
    } else if ("ru".equals(lang)) {
        locale = new Locale("ru", "ru");
    } else {
        locale = Locale.getDefault();
    }
    ResourceBundle res = ResourceBundle.getBundle("lg", locale);
%>

<div class='header'>
    <a class="btn_user"><%= res.getString("btn_enter")%></a>
    <a class="btn_user" href="/cart"><%= res.getString("btn_cart")%>    </a>
    <a class="btn_user" ><%= res.getString("btn_history")%></a>
    <div style="float:right">
        <a href="?lang=ru" class="buttn_lng"><i>Ru</i></a>
        <a href="?lang=en" class="buttn_lng"><i>En</i></a>
        <a href="?lang=gr" class="buttn_lng"><i>Ge</i></a>
    </div>

    <h1 style=" border-top:1px solid #fffbf7; margin: 0;padding:0;font-size:60pt; font-family: 'Brush Script MT' ; text-align: center; color:#fffbf7;">
        <a style="text-decoration: none; background: rgba(212, 75, 56, 0); color: #fffbf7;" href="/">Boards only</a>
    </h1>



</div>