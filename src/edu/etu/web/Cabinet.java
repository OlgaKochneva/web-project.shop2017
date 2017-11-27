package edu.etu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Cabinet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("username",request.getUserPrincipal().getName());
        String default_tab = request.getParameter("default_tab");
        response.addCookie(new Cookie("default_tab", default_tab));
        request.getSession().setAttribute("default_tab", default_tab);
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("username",request.getUserPrincipal().getName());
        Cookie[] cookies = request.getCookies();
        String lang = request.getParameter("lang");
        String default_tab = (String)request.getSession().getAttribute("default_tab");
        String user = (String)request.getSession().getAttribute("username");
        if(user==null)
        {
            getServletContext().getRequestDispatcher("/auth/auth.jsp").forward(request,response);
        }


        if(lang == null) {
            for (Cookie c : cookies) {
                if ("lang".equals(c.getName()))
                    lang = c.getValue();

            }
        }
        if(default_tab==null)
        {
            default_tab=getInitParameter("default_tab");
        }
        request.getSession().setAttribute("locale", lang);
        response.addCookie(new Cookie("lang",lang));

        Locale locale;
        if ("en".equals(lang)) {
            locale = new Locale("en", "en");
        } else if ("gr".equals(lang)) {
            locale = new Locale("gr", "gr");
        } else if ("ru".equals(lang)) {
            locale = new Locale("ru", "ru");
        }else {
            locale = Locale.getDefault();
        }
        ResourceBundle resources = ResourceBundle.getBundle("lg", locale);
        response.addCookie(new Cookie("lang",lang));
        session.setAttribute("locale", lang);
        StringBuilder sb = new StringBuilder();
        sb.append("<html lang=\"en\">\n" +
                "<head>\n" +
                "<link href=\"./button_style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n"+
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Boards only</title>\n" +
                "<link href=\"../auth_form.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n"+
                "<link rel=\"shortcut icon\" href=\"/pics/empt.png\" type=\"image/png\">\n"+
                "<script src=\"./js/Cart_worker.js\"></script>\n"+
                "<script src=\"./js/cabinet_worker.js\"></script>\n"+
                "<script src=\"./js/Tab_clicked.js\"></script>\n"+
                "</head>");
        sb.append("<body onload =\"checked('" + default_tab + "')\" style=\"background-image: url(./pics/bod.png); background-repeat:no-repeat;\n" +
                "background-attachment:fixed;\">");
        sb.append("<div>\n" +
                "<div>\n"+
                "    <a class=\"btn_user\" href=\"/cart\">"+resources.getString("btn_cart")+"</a>\n" +
                "    <a class=\"btn_user\" >"+resources.getString("btn_history")+"</a>\n" +
                "</div>\n"+
                "        <h1 style=\" border-top:1px solid #fffbf7; margin: 0;padding:0;font-size:60pt; font-family: 'Brush Script MT' ; text-align: center; color:#fffbf7;\">\n" +
                "              <a style=\"text-decoration: none; background: rgba(212, 75, 56, 0); color: #fffbf7;\n"+
                "\" href=\"/\">Boards only</a>\n" +
                "        </h1>\n" +
                "        <div style=\"float:right\">\n" +
                "            <a href=\"?lang=ru\" class=\"buttn_lng\"><i>Ru</i></a>\n" +
                "            <a href=\"?lang=en\" class=\"buttn_lng\"><i>En</i></a>\n" +
                "            <a href=\"?lang=gr\" class=\"buttn_lng\"><i>Ge</i></a>\n" +
                "        </div>\n" +
                "\n" +
                "</div>");

        sb.append("<div class='cabinet'>");
        sb.append("<div style=\"margin-left:30px; margin-top: 20px;\">" + resources.getString("logged_in") + user);
        sb.append("<form action='./cabinet' method='post' id='cabinet_form'>");
        sb.append(resources.getString("def") + ":<br>");
        sb.append("    <span><input id='b1'  name='default_tab' type='radio' value='1'>" +  resources.getString("titlesh") + "</span><br>");
        sb.append("    <span><input id='b2' name='default_tab' type='radio' value='2'>" +  resources.getString("titlel") + "</span><br>");
        sb.append("    <span><input id='b3'  name='default_tab' type='radio' value='3'>" +  resources.getString("titlere") + "</span><br>");
        sb.append("    <span><button class=\"OK\" type=\"submit\" >OK</button></span>");
        sb.append(" </form>");
        sb.append("    <span><a href='./exit' class=\"OK\">"+resources.getString("btn_exit") + "</a></span></div>");
        sb.append("</div>");
        sb.append("</body></html>");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(sb.toString());
        out.close();
    }
}