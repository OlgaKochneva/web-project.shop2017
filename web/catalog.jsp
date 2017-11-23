<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="./button_style.css" rel="stylesheet" type="text/css" media="all">
    <script src="./js/filtration.js"></script>
    <title>BoardsOnly</title>

    <jsp:useBean id="BoardBean" class="myBean.BoardBean" scope="session"/>
</head>
<body onload="sort()" ;
      style="background-image: url(bod.png); background-repeat:no-repeat; background-attachment:fixed;">
<div>

        <h1 style="margin: 0;padding:0;font-size:60pt; font-family: 'Brush Script MT' ; text-align: center; color:#fffbf7;">
            Boards only
        </h1>

    <jsp:include page="header.jsp"/>
</div>

<div style=" border-top:1px solid #fffbf7;margin-top: 50px; margin-left: 7px " ; id='container'>
    <span  style="position:relative; right: 19%;" id="sort"><a class="myLin" onclick="sort(0)" id="a0">Show all</a> | <a class="myLin" onclick="sort(1)" id="a1">22</a>
     | <a class="myLin" onclick="sort(2)" id="a2">27</a> | <a class="myLin"   onclick="sort(3)" id="a3">Longboard</a></span>

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
</div>
</body>
</html>
