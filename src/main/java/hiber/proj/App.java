package hiber.proj;

import hiber.proj.model.Director;
import hiber.proj.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Film.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Film film = session.get(Film.class, 1);
            System.out.println(film);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}