<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="./button_style.css" rel="stylesheet" type="text/css" media="all">
    <link rel="shortcut icon" href="/pics/empt.png" type="image/png">
    <script src="./js/filter.js"></script>
   <%--// <script src="./js/login_worker.js"></script>--%>
    <script src="./js/Cart_worker.js"></script>
    <title>BoardsOnly</title>

    <jsp:useBean id="BoardBean" class="myBean.BoardBean" scope="session"/>
</head>
<body onload="sort()" ;
      style="background-image: url(./pics/bod.png); background-repeat:no-repeat; background-attachment:fixed;">
<div >

    <jsp:include page="header.jsp"/>
</div>

<div style=" border-top:1px solid #fffbf7;margin-top: 25px; margin-left: 7px " ; id='container'>
    <span id="sort"><a class="myLin" onclick="sort(0)">Show all</a> | <a class="myLin" onclick="sort(1)">22</a> | <a class="myLin"onclick="sort(2)">27</a>
        | <a class="myLin" onclick="sort(3)" >Longboard</a></span>

    <%
        String img;
        for (int i = 1; i < 4; i++) {
            img = "./pics/" + "img" + Integer.toString(i) + ".png";
    %>
    <jsp:setProperty name="BoardBean" property="id" value="<%= i%>"/>
    <jsp:setProperty name="BoardBean" property="imageUrl" value="<%=img%>"/>
    <div>
        <jsp:include page="/item.jsp"/>
    </div>
    <%
        }
    %>
</div>

</body>
</html>
