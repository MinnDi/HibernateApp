package org.example;

import org.example.mindi.entity.Principal;
import org.example.mindi.entity.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            Director director = session.get(Director.class, 1);
//            System.out.println(director.getMovies());
//
//            Movie movie = session.get(Movie.class, 5);
//            System.out.println(session.get(Director.class, movie.getDirector().getDirectorId()).getName());
//
//            movie = new Movie("Dune", 1984);
//            director = session.get(Director.class, 5);
//            movie.setDirector(director);
//            director.addMovie(movie);
//            session.save(movie);
//
//            director = new Director("Steven Spielberg", 75);
//            movie = new Movie("Catch Me If You Can", 2002);
//            movie.setDirector(director);
//            director.addMovie(movie);
//            session.persist(director);
//
//            movie = session.get(Movie.class, 4);
//            movie.setDirector(session.get(Director.class, 7));
//            session.get(Director.class,7).getMovies().remove(movie);
//            session.save(movie);
//
//            movie = session.get(Movie.class, 4);
//            session.delete(movie);

            School school = session.get(School.class, 1);
            System.out.println(school.getPrincipal().getName());

            Principal principal = session.get(Principal.class, 4);
            System.out.println(principal.getSchool().getSchoolNumber());

//            principal = new Principal("Dilyara", 23);
//            school = new School(505);
//            principal.setSchool(school);
//            session.save(principal);

//            principal.setSchool(session.get(School.class, 5));
//            session.save(principal);

            school = session.get(School.class, 5);
            school.setPrincipal(null);
            principal = session.get(Principal.class, 5);
            school = session.get(School.class, 3);
            principal.setSchool(school);
            session.save(principal);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
