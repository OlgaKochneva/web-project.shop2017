package edu.etu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class catalog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String filter_param = getInitParameter("filter");
        String lang = request.getParameter("lang");
        HttpSession ss = request.getSession();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("lang".equals(c.getName()) && lang == null)
                    lang = c.getValue();

                if ("filter".equals(c.getName())) {
                    filter_param = c.getValue();
                }
            }
        }
        response.addCookie(new Cookie("filter", filter_param));

        if(lang == null)
            lang = "en";
        response.addCookie(new Cookie("lang", lang));
        ss.setAttribute("locale", lang);

        getServletContext().getRequestDispatcher("/catalog.jsp").forward(request, response);
    }
}
