package dbTools;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommentService {
    public static ArrayList<CommentEntity> getAllComments() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List purchases = session.createQuery("FROM CommentEntity").list();
        ArrayList<CommentEntity> orders = new ArrayList<>();

        for (Iterator iterator = purchases.iterator(); iterator.hasNext(); ) {
            CommentEntity order = (CommentEntity) iterator.next();
            orders.add(order);
        }

        session.getTransaction().commit();
        session.close();
        return orders;
    }

    public static void saveComment(CommentEntity comment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(comment);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteComment(int id, String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CommentEntity comment = session.get(CommentEntity.class, id);
        if (comment.getUserName().equals(username)) {
            session.delete(comment);
            session.flush();
        }

        session.getTransaction().commit();
        session.close();
    }
}
