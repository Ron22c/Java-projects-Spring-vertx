import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

//        INSERT INTO table_name (first_name, last_name) VALUES ("Ranajit", "Chandra");
//        User user = new User("Ranajit", "Chandra");
//        session.save(user);

//        SELECT * FROM table_name WHERE user_id = 1;
//        User user = new User();
//        user = session.get(User.class, 1);

//        UPDATE table_name SET first_name='RONO' WHERE user_id = 1;
//        user.setFirstName("RONO");


        // DELETE FROM table_name WHERE user_id = 2;
        User user;
        session.beginTransaction();
        user = session.get(User.class, 2);
        session.delete(user);
        session.getTransaction().commit();
        System.out.println(user);
    }
}
