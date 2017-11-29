package edu.etu.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class catalog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("j_username");

        if(user == null || user == ""){
            response.sendRedirect("/login");
        }else {
            request.getSession().setAttribute("username", user);
            response.addCookie(new Cookie("user", user));

            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String filter_param = getInitParameter("filter");
        String lang = request.getParameter("lang");
        HttpSession ss = request.getSession();
        Boolean Empty=(Boolean)ss.getAttribute("Empty");
        int []countp=new int[3];
        for(int i=0;i<3;i++)
        {
            countp[i]=0;
        }
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("lang".equals(c.getName()) && lang == null)
                    lang = c.getValue();

                if ("filter".equals(c.getName())) {
                    filter_param = c.getValue();
                }
                if ("user".equals(c.getName()))
                    ss.setAttribute("username", c.getValue());
                for(int i=1;i<4;i++){
                    if(("c"+i).equals(c.getName()))
                    {
                        countp[i-1]=Integer.parseInt(c.getValue());

                    }
                }
            }
        }
        response.addCookie(new Cookie("filter", filter_param));

        if(lang == null)
            lang = "ru";
        response.addCookie(new Cookie("lang", lang));
        ss.setAttribute("locale", lang);
        getServletContext().getRequestDispatcher("/catalog.jsp").forward(request, response);
    }
}
