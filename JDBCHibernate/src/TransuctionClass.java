import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TransuctionClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();


//        = new User("Ron", "chandra");
        session.beginTransaction();
        User user = session.get(User.class, 3);
        user.setFirstName("Ranajit");
        session.getTransaction().commit();


    }

}
