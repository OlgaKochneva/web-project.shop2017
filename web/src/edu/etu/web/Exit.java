package edu.etu.web;

import java.io.IOException;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Exit extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Cookie cookie : request.getCookies()) {
            cookie.setValue("");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        request.getSession().invalidate();
        log(new Date().toString() + ": пользователь " + request.getSession().getAttribute("username") + " вышел");
        response.sendRedirect(".");
    }
}