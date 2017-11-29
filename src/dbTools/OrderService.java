package dbTools;

import myBean.Boardlist;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderService {
    public static  ArrayList<OrdersEntity> getUserAllPurchases(String userName){
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List purchases = session.createQuery("FROM OrdersEntity").list();
        ArrayList<OrdersEntity> orders = new ArrayList<>();
        for(Iterator iterator = purchases.iterator(); iterator.hasNext();){
            OrdersEntity order = (OrdersEntity)iterator.next();
            if(order.getUserName().equals(userName))
                orders.add(order);
        }

        session.getTransaction().commit();
        session.close();
        return orders;
    }

    public static void saveOrder(OrdersEntity order){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }
}
