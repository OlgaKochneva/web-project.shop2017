package edu.etu.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Lab1Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lang = request.getParameter("lang");
        HttpSession ss = request.getSession();
        Cookie[] cookies = request.getCookies();
        String user = (String) ss.getAttribute("username");
        int[] count_purchases = new int[3];//подсчет товаров
        Boolean Cart_is_Empty = true;//для проверки наличия товаров в корзине
        if (lang == null) {
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("lang".equals(c.getName()))
                        lang = c.getValue();
                    for (int i = 1; i < 4; i++) {
                        if (("c" + i).equals(c.getName())) {
                            count_purchases[i - 1] = 0;
                            count_purchases[i - 1] = Integer.parseInt(c.getValue());
                            if (count_purchases[i - 1] != 0) Cart_is_Empty = false;//если товар есть то корзина не пуста
                        }
                    }
                }
            } else {
                lang = getInitParameter("lang");
            }
        }
        ss.setAttribute("locale", lang);
        response.addCookie(new Cookie("lang", lang));
        //локализация
        Locale locale;
        if ("en".equals(lang)) {
            locale = new Locale("en", "en");
        } else if ("ru".equals(lang)) {
            locale = new Locale("ru", "ru");
        } else if ("gr".equals(lang)) {
            locale = new Locale("gr", "gr");
        } else {
            locale = Locale.getDefault();
        }

        //отображение вкладки по умолчанию выбранной пользователем или по дефолту
        int value = -1;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("default_tab".equals(c.getName()))
                    value = Integer.parseInt(c.getValue());
            }
        }

        if (value == -1)
            value = Integer.parseInt(getInitParameter("default_tab"));

        ResourceBundle resources = ResourceBundle.getBundle("lg", locale);
        String id = request.getParameter("id");
        //для соответствия типов
        int _id;
        try {
            _id = Integer.parseInt(id);
        } catch (Exception ex) {
            _id = 0;
        }

        if (id == null || _id < 1 || _id > 3) {
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("id".equals(c.getName()))
                        id = c.getValue();
                }
            } else {
                id = "1";
            }
        }
        response.addCookie(new Cookie("id", id));

        String userinfo = "<a class=btn_user href='./cabinet' >" + resources.getString("btn_enter") + "</a>";

        if (user != null && user != "")
            userinfo = "<a class=myLin href='./cabinet' >" + resources.getString("logged_in") + " <b>" + user + "</b></a>";
        StringBuilder sb = new StringBuilder();

        sb.append("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Boards only</title>\n" +
                "<link href=\"./main.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n" +
                "<link rel=\"shortcut icon\" href=\"/pics/empt.png\" type=\"image/png\">\n" +
                "<link href=\"./auth_form.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n" +
                "<script src=\"./js/Cart_worker.js\"></script>\n" +
                "<script src=\"./js/Tab_clicked.js\"></script>\n" +
                "</head>");
        sb.append("<body onload =\"openfirstTab('" + value + "')\" style=\"background-image: url(./pics/bod.png); background-repeat:no-repeat;\n" +
                "background-attachment:fixed;\">");
        sb.append("	</div>");
        sb.append("<div class='header'>\n" +
                "<div>\n" + userinfo +
                "    <a class=\"btn_user\" href=\"/cart\">" + resources.getString("btn_cart") + "</a>\n");
        if (!Cart_is_Empty) {
            if (user == null || user.equals(""))
            {
                sb.append("<a class=\"btn_user\"  href=\"/cabinet\">" + resources.getString("btn_doorder") + "</a>\n");
            }
            else{
                sb.append("<a class=\"btn_user\"  href=\"/order\">" + resources.getString("btn_doorder") + "</a>\n");
            }
        }
        sb.append("</div><h1 style=\" border-top:1px solid #fffbf7; margin: 0;padding:0;font-size:60pt; font-family: 'Brush Script MT' ; text-align: center; color:#fffbf7;\">\n" +
                "              <a style=\"text-decoration: none; background: rgba(212, 75, 56, 0); color: #fffbf7;\n" +
                "\" href=\"/\">Boards only</a>\n" +
                "        </h1>\n" +
                "        <div style=\"float:right\">\n" +
                "            <a href=\"?lang=ru\" class=\"buttn_lng\"><i>Ru</i></a>\n" +
                "            <a href=\"?lang=en\" class=\"buttn_lng\"><i>En</i></a>\n" +
                "            <a href=\"?lang=gr\" class=\"buttn_lng\"><i>Ge</i></a>\n" +
                "        </div>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "<!--Расположение таблицы-->\n" +
                "<div style=\"margin-top: 0; margin-left: 2% \">\n" +
                "\n" +
                "    <table border=\"0\">\n" +
                "        <tr>\n" +
                "\n" +
                "<td height=\"50\">\n" +
                "<div class=\"knopka3\">\n" +
                "<i>" + resources.getString("pr2") + resources.getString("price" + id) + resources.getString("pr") + "</i>\n" +
                "<a class=\"btn_buy\" href=\"/Lab1Servlet\" onclick=\"to_cart(" + id + ")\"<i>" + resources.getString("btn_buy") + "</i></a>\n" +
                "</div>\n" +
                "</td>\n" +
                "<td>\n" +
                "<div class=\"knopka\" >\n" +
                "<button class= \"tab\" onclick=openTab(event,'1')><i>" + resources.getString("button1") + "</i></button>\n" +
                "<button class=\"tab\" onclick=openTab(event,'2')><i>" + resources.getString("button2") + "</i></button>\n" +
                "<button class=\"tab\" onclick=openTab(event,'3')><i>" + resources.getString("button3") + "</i></button>" +
                "</div>\n" +
                "</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <img height=440px width=430px src='./pics/img" + id + ".png'>\n" +
                "            </td>\n" +
                "\n" +
                "            <td style=\"font-size:20px; background-color:rgba(255,255,255, 0.4); width: 100%;\n" +
                "                        border-radius:25px;vertical-align: top;\">\n" +
                "                <div class=\"tabs\" id=\"1\">\n" +
                "<p style=\"font-size:31px;margin-left: 10px\"><i>" + resources.getString("titlesh") + resources.getString("name" + id) + "<br></i></p>\n" +
                "       <p style=\"font-size:20px; color:rgba(0,0,0,1);margin-left: 10px\"> <i>\n" +
                resources.getString("short" + id) +
                "</i></p>\n" +
                "                </div>\n" +
                "                <div class=\"tabs\" id=\"2\">\n" +
                "<p style=\"font-size:31px;margin-left: 10px\"><i>\n" + resources.getString("titlel") + resources.getString("name" + id) + "<br></i></p>\n" +
                resources.getString("list" + id) +

                "\n" +
                "                </div>\n" +
                "                <div class=\"tabs\" id=\"3\" style=\"font-size: 20px; font-style: italic\">\n" +
                " <p style=\"font-size:31px;margin-left: 10px\"><i>" + resources.getString("titlere") + resources.getString("name" + id) + "<br></i></p>\n" +
                resources.getString("review1") +
                "            </td>\n" +
                "\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        response.setContentType("text/html; charset=UTF-8");
        ss.setAttribute("Empty", Cart_is_Empty);
        PrintWriter out = response.getWriter();
        out.println(sb.toString());
        out.close();
    }
}
