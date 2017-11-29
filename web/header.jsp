<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String lang = (String) request.getSession().getAttribute("locale");
    HttpSession ss = request.getSession();
    Cookie[] cookies = request.getCookies();
    boolean Empty=true;
    int []countp=new int[3];
    if (cookies != null) {
        for (Cookie c : cookies) {
    for(int i=1;i<4;i++){
        if(("c"+i).equals(c.getName()))
        {
            countp[i-1]=Integer.parseInt(c.getValue());
            if(countp[i-1]!=0)Empty=false;
        }
    }}}
    ss.setAttribute("Empty",Empty);
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
    String user = (String)ss.getAttribute("username");
    ResourceBundle res = ResourceBundle.getBundle("lg", locale);
%>

<div>
    <% if(user==""||user==null){
    %>
    <a class="btn_user" href="/cabinet"><%=res.getString("btn_enter")%></a>
    <%}else{%>

    <a class="myLin" href="./cabinet" ><%=res.getString("logged_in")%> <b><%= user%></b></a>
    <a class="btn_user" ><%= res.getString("btn_history")%></a>
        <%
        }
   %>

    <a class="btn_user"  href="/cart"><%= res.getString("btn_cart")%></a>
    <% if(!Empty){
    %>
    <% if(user==""||user==null){
    %>
    <a class="btn_user" href="/cabinet"><%=res.getString("btn_doorder")%></a>
    <%}else{%>
    <a class="btn_user"  href="/order"><%= res.getString("btn_doorder")%></a>
    <%
        }
    %>
    <%
        }
    %>
    <div style="float:right">
        <a href="?lang=ru" class="buttn_lng"><i>Ru</i></a>
        <a href="?lang=en" class="buttn_lng"><i>En</i></a>
        <a href="?lang=gr" class="buttn_lng"><i>Ge</i></a>
    </div>
    <h1 style=" border-top:1px solid #fffbf7; margin: 0;padding:0;font-size:60pt; font-family: 'Brush Script MT' ; text-align: center; color:#fffbf7;">
        <a style="text-decoration: none; background: rgba(212, 75, 56, 0); color: #fffbf7;" href="/">Boards only</a>
    </h1>



</div>