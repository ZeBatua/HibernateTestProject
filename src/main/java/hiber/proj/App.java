package hiber.proj;

import hiber.proj.model.Director;
import hiber.proj.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Film.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director = new Director("TestDirector", 43);
            Film film1 = new Film("test1", 1993, director);

            // add obj on owning side for cashes
            director.setFilms(new ArrayList<>(Collections.singletonList(film1)));

            session.save(director);
            session.save(film1);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}