package edu.etu.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.Locale;
import java.util.ResourceBundle;


public class Lab1Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        String lang = request.getParameter("lang");
        Locale locale;
        if ("en".equals(lang)) {
            locale = new Locale("en", "en");
        } else if ("ru".equals(lang)) {
            locale = new Locale("ru", "ru");
        } else if ("gr".equals(lang)) {
            locale = new Locale("gr", "gr");
        }else {
            locale = Locale.getDefault();
        }

        int  value = Integer.parseInt(getInitParameter("default_tab"));
        ResourceBundle resources = ResourceBundle.getBundle("lg", locale);

        StringBuilder sb = new StringBuilder();


        sb.append("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Boards only</title>\n" +
                "</head>\n" +
                "\n" +
                "<!--Стили кнопок-->\n" +
                "<style>\n" +
                "div.knopka button {\n" +
                "        border-radius: 15px;\n" +
                "        float: left;\n" +
                "        border: none;\n" +
                "        outline: none;\n" +
                "        cursor: pointer;\n" +
                "        transition: 0.4s;\n" +
                "        font-size: 22px;\n" +
                "        font-family: 'Times New Roman';\n" +
                "        color: #fffbf7;\n" +
                "        background: rgba(212, 75, 56, 0);\n" +
                "        padding: .7em 0.59em;\n" +
                "    }\n" +
                "\n" +
                "    div.knopka button:hover {\n" +
                "        background-color: rgba(0, 0, 0, 0.2);\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    div.knopka button.active {\n" +
                "        background-color: rgba(255, 255, 255, 0.2);\n" +
                "    }\n" +
                "\n" +
                "div.knopka3 {\n" +
                "        position: relative;\n" +
                "        left: 12%;\n" +
                "        font-family: 'Times New Roman';\n" +
                "        font-size: 24px;\n" +
                "        color: #fffbf7; /* цвет текста */\n" +
                "    }\n" +
                "    div.knopka3 button {\n" +
                "       width:43%;\n" +
                "        font-size: 22px;\n" +
                "        position: relative;\n" +
                "        left: 5%;\n" +
                "        border-radius: 15px;\n" +
                "        border: none;\n" +
                "        outline: none;\n" +
                "        cursor: pointer;\n" +
                "        transition: 0.4s;\n" +
                "        font-family: 'Times New Roman';\n" +
                "        font-size: 22px;\n" +
                "        color: #fffbf7; /* цвет текста */\n" +
                "        background: rgba(0, 0, 0, 0.2); /* фон кнопки */\n" +
                "        padding: .7em 2.0em; /* отступ от текста */\n" +
                "    }\n" +
                "    div.knopka3 button:hover {\n" +
                "        background-color: rgba(255, 255, 255, 0.2);\n" +
                "    }\n" +
                "\n" +
                "    /* при наведении курсора мышки */\n" +
                "    div.knopka3 button:active {\n" +
                "        background-color: rgba(0, 0, 0, 0.2);\n" +
                "    }\n" +

                "    a.buttn_lng {\n" +
                "        position: relative;\n" +
                "        left: 36%;\n" +
                "        border-color: black;\n" +
                "        border-radius: 35px;\n" +
                "        font-size: 15px;\n" +
                "        color: #fffbf7; /* цвет текста */\n" +
                "        text-decoration: none; /* убирать подчёркивание у ссылок */\n" +
                "        user-select: none; /* убирать выделение текста */\n" +
                "        background: rgba(212, 75, 56, 0); /* фон кнопки */\n" +
                "        padding: .7em 0.59em; /* отступ от текста */\n" +
                "    }\n" +
                "\n" +
                "    a.buttn_lng:hover {\n" +
                "        background: rgba(255, 255, 255, 0.2);\n" +
                "    }\n" +
                "\n" +
                "    /* при наведении курсора мышки */\n" +
                "    a.buttn_lng:active {\n" +
                "        background: rgba(0, 0, 0, 0.2);\n" +
                "    }\n" +
                "\n" +
                "</style>\n" +
                "<!--Стиль списка-->\n" +
                "<style>\n" +
                "    .li1 {\n" +
                "        list-style-type: none;\n" +
                "\n" +
                "        margin-left: 10px;\n" +
                "        margin-top: 20px;\n" +
                "        font-style: italic;\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    li:before {\n" +
                "        content: \"o \";\n" +
                "    }\n" +
                "</style>\n" +
                "<!--Функционал кнопок-->\n" +
                "<script>\n" +
                "    function openTab(evt, tabName) {\n" +
                "        var i, tabs, tab;\n" +
                "\n" +
                "        tabs = document.getElementsByClassName(\"tabs\");\n" +
                "        for (i = 0; i < tabs.length; i++) {\n" +
                "            tabs[i].style.display = \"none\";\n" +
                "        }\n" +
                "\n" +
                "        tab = document.getElementsByClassName(\"tab\");\n" +
                "        for (i = 0; i < tab.length; i++) {\n" +
                "            tab[i].className = tab[i].className.replace(\" active\", \"\");\n" +
                "        }\n" +
                "\n" +
                "        document.getElementById(tabName).style.display = \"block\";\n" +
                "        evt.currentTarget.className += \" active\";\n" +
                "\n" +
                "    }\n" +
                "</script>\n" +
                "<script>\n" +
                "    function openfirstTab(tabName) {\n" +
                "        var i, tabs, tab;\n" +
                "\n" +
                "        tabs = document.getElementsByClassName(\"tabs\");\n" +
                "        for (i = 0; i < tabs.length; i++) {\n" +
                "            tabs[i].style.display = \"none\";\n" +
                "        }\n" +
                "\n" +
                "        tab = document.getElementsByClassName(\"tab\");\n" +
                "        for (i = 0; i < tab.length; i++) {\n" +
                "            tab[i].className = tab[i].className.replace(\" active\", \"\");\n" +
                "          if(tabName == tabs[i].getAttribute(\"id\"))\n" +
                "            {\n" +
                "                tabs[i].style.display =\"block\";\n" +
                "                tab[i].className += \" active\";\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "</script>\n" +
                "<body onload =\"openfirstTab('" + value + "')\" style=\"background-image: url(bod.png)\">\n" +
                "<!--Заголовок-->\n" +
                "<h1 style=\"margin: 0;padding:0;font-size:60pt; font-family: 'Brush Script MT' ; text-align: center; color:#fffbf7;\">\n" +
                "    Boards-only\n" +
                "</h1>\n" +
                "<!--Расположение таблицы-->\n" +
                "<div style=\"margin-top: 0; margin-left: 2% \">\n" +
                "\n" +
                "    <table border=\"0\">\n" +
                "        <tr>\n" +
                "\n" +
                "<td height=\"50\">\n" +
                "<div class=\"knopka3\">\n" +
                "<i>" + resources.getString("price") + "</i>\n" +
                "<button class=\"buttn_buy\" <i>" + resources.getString("btn_buy") + "</i></button>\n" +
                "\n" +
                "</div>\n" +
                "</td>\n" +
                "<td>\n" +
                "<div class=\"knopka\" >\n" +
                "<button class= \"tab\" onclick=openTab(event,'1')><i>" + resources.getString("button1") + "</i></button>\n" +
                "<button class=\"tab\" onclick=openTab(event,'2')><i>" + resources.getString("button2") + "</i></button>\n" +
                "<button class=\"tab\" onclick=openTab(event,'3')><i>" + resources.getString("button3") + "</i></button>" +
                "</div>\n" +
                "\n" +
                "<div>\n" +
                "<a href=\"?lang = ru\" class=\"buttn_lng\"><i>Ru</i></a>\n" +
                "<a href=\"?lang=en\" class=\"buttn_lng\"><i>En</i></a>\n" +
                "<a href=\"?lang=gr\" class=\"buttn_lng\"><i>Ge</i></a>\n" +
                "</div>\n" +
                "</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <img height=440px width=430px src=\"imh.png\">\n" +
                "            </td>\n" +
                "\n" +
                "            <td style=\"font-size:20px; background-color:rgba(255,255,255, 0.4); width: 100%;\n" +
                "                        border-radius:25px;vertical-align: top;\">\n" +
                "                <div class=\"tabs\" id=\"1\">\n" +
                resources.getString("short") +
                "\n" +
                "                </div>\n" +
                "                <div class=\"tabs\" id=\"2\">\n" +
                "\n" +
                resources.getString("list") +


                "\n" +
                "                </div>\n" +
                "                <div class=\"tabs\" id=\"3\" style=\"font-size: 20px; font-style: italic\">\n" +
                resources.getString("review") +
                "            </td>\n" +
                "\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(sb.toString());
        out.close();
    }
}
