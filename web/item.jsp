<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="edu.etu.web.catalog" %>
<%@ page import="myBean.BoardBean" %>

<head>
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
    <jsp:useBean id="BoardBean" class="myBean.BoardBean" scope="session"/>

    <script src="./js/cart_worker.js"></script>
</head>

<%
    int id = BoardBean.getId();
    BoardBean.setType(res.getString("type"+ Integer.toString(id)));
    String tp = BoardBean.gettype();
    BoardBean.setName(res.getString("name" + Integer.toString(id)));
    BoardBean.setDescription(res.getString("short" + Integer.toString(id)));
    BoardBean.setPrice(Double.parseDouble(res.getString("price" + Integer.toString(id))));
%>

<div id="i<%= id%>" class="<%= tp%>" >
    <div class="box">
    <table >
        <tr>
            <td>
                <h1><a class="myLin" href="/Lab1Servlet?id=<%=Integer.toString(id)%>">
                    <jsp:getProperty name="BoardBean" property="name"/>
                </a></h1>
            </td>
            <td>
        <span class='cost'><a class=buttn_lng onclick="to_cart(<%= id%>)"><%=res.getString("btn_buy")%>
                        | <span class="price"><jsp:getProperty name="BoardBean"
                                                               property="price"/> <%=res.getString("pr")%></span></a></span>
            </td>
        </tr>
        <tr>
            <td>
                <img height=230px width=220px src="<jsp:getProperty name="BoardBean" property="imageUrl"/>">
            </td>
            <td>
                <jsp:getProperty name="BoardBean" property="description"/>
            </td>
        </tr>
    </table>
    </div>
</div>




