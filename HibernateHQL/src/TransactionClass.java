import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TransactionClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        User user = new User("ranajitChandra", "rollno21");
        session.beginTransaction();
//        session.save(user);

        session.createQuery("UPDATE User set firstName='Chandra', lastName='Ranajit' WHERE userId=7").executeUpdate();
//        session.createQuery("DELETE User WHERE userId=5 OR userId=6").executeUpdate();
        List<User> users = session.createQuery("FROM User WHERE lastName LIKE '%ran%'").getResultList();
        for(User use : users) {
            System.out.println(use);
        }

        session.getTransaction().commit();

    }
}
