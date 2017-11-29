package edu.etu.web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import myBean.Board;
import myBean.Boardlist;
import dbTools.OrdersEntity;
import dbTools.OrderService;

public class Order extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession ss = request.getSession();
        String userName = (String)ss.getAttribute("username");
        String lang = request.getParameter("lang");
        Cookie[] cookies = request.getCookies();
        boolean Cart_is_Empty=true;
        int []countp=new int[3];
        for(int i=0;i<3;i++)
        {
            countp[i]=0;
        }

        try {
            for (Cookie c : cookies) {
                for(int i=1;i<4;i++){
                    if(("c"+i).equals(c.getName()))
                    {
                        countp[i-1]=Integer.parseInt(c.getValue());
                        if(countp[i-1]!=0)Cart_is_Empty=false;
                    }
                }
                if ("lang".equals(c.getName()) && lang == null )
                    lang = c.getValue();
            }
        }catch (Exception ex){};

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

        ResourceBundle bundle = ResourceBundle.getBundle("lg", locale);

        Boardlist boards = new Boardlist();

        for(int i=1;i<4;i++)
        {
            boards.addPurchase(new Board(i, bundle.getString("name"+i), bundle.getString("short"+i), "./pics/img"+i+".png", countp[i-1], Double.parseDouble(bundle.getString("price"+i))));
        }

        response.addCookie(new Cookie("lang",lang));

        ss.setAttribute("purchases", boards);
        Boardlist purchasesList = (Boardlist)ss.getAttribute("purchases");

        String purchases = purchasesList.getStr(purchasesList);

        OrdersEntity order;

        String withCurier = request.getParameter("type-choice");
        if(withCurier!=null && withCurier.equals("on")){
            String addressee = request.getParameter("addressee");
            order = new OrdersEntity(userName, purchases, (byte)1, addressee);
        } else {
            int shopId = Integer.parseInt(request.getParameter("shop-choice"));
            order = new OrdersEntity(userName, purchases, (byte)0, shopId);
        }

        OrderService.saveOrder(order);

        ss.setAttribute("Empty",Cart_is_Empty);
        ss.setAttribute("purchases","");
        ss.setAttribute("order_success", true);

        response.addCookie(new Cookie("c1", "0"));
        response.addCookie(new Cookie("c2", "0"));
        response.addCookie(new Cookie("c3", "0"));

        response.sendRedirect(".");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ss = request.getSession();
        String lang = request.getParameter("lang");
        ss.setAttribute("locale", lang);
        getServletContext().getRequestDispatcher("/Order.jsp").forward(request,response);
    }
}