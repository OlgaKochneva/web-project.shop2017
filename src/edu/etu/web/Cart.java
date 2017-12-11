package edu.etu.web;

import myBean.Boardlist;
import myBean.Board;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Cart extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ss = request.getSession();
        String lang = request.getParameter("lang");
        Cookie[] cookies = request.getCookies();

        int[] count_purchases = new int[3];

        try {
            for (Cookie c : cookies) {
                for (int i = 1; i < 4; i++) {
                    if (("c" + i).equals(c.getName())) {
                        count_purchases[i - 1] = 0;
                        count_purchases[i - 1] = Integer.parseInt(c.getValue());

                    }
                }
                if ("lang".equals(c.getName()) && lang == null)
                    lang = c.getValue();
            }
        } catch (Exception ex) {
        }
        int total = 0;
        for (int count_purchase : count_purchases) {
            total = count_purchase + total;
        }

        log(new Date().toString() + ": пользователь " + ss.getAttribute("username") + " смотрит корзину с " + total + "товаром(и)");

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

        ResourceBundle bundle = ResourceBundle.getBundle("lg", locale);
        Boardlist purchases = new Boardlist();
        //добавляем покупки которые будем отображать
        for (int i = 1; i < 4; i++) {
            purchases.addPurchase(new Board(i, bundle.getString("name" + i), bundle.getString("short" + i), "./pics/img" + i + ".png", count_purchases[i - 1], Double.parseDouble(bundle.getString("price" + i))));
        }

        response.addCookie(new Cookie("lang", lang));

        ss.setAttribute("locale", lang);
        ss.setAttribute("purchases", purchases);

        getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
    }
}
