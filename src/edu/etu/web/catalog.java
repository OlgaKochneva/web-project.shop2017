package edu.etu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class catalog extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        String filter_param = getInitParameter("filter");
        String lang = request.getParameter("lang");
        HttpSession ss = request.getSession();
        Boolean Empty = true;

        int[] count_purchases = new int[3];

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("lang".equals(c.getName()) && lang == null)
                    lang = c.getValue();

                if ("filter".equals(c.getName())) {
                    filter_param = c.getValue();
                }
                for (int i = 1; i < 4; i++) {
                    if (("c" + i).equals(c.getName())) {
                        count_purchases[i - 1] = 0;
                        count_purchases[i - 1] = Integer.parseInt(c.getValue());
                        if (count_purchases[i - 1] != 0) Empty = false;

                    }
                }
            }
        }
        response.addCookie(new Cookie("filter", filter_param));
        if (lang == null) lang = "ru";
        response.addCookie(new Cookie("lang", lang));
        ss.setAttribute("locale", lang);
        ss.setAttribute("Empty", Empty);
        getServletContext().getRequestDispatcher("/catalog.jsp").forward(request, response);
    }
}
