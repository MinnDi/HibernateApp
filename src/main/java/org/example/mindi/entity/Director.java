package org.example.mindi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @Column(name = "director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int directorId;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @OneToMany(mappedBy = "director", cascade = CascadeType.PERSIST)
    List<Movie> movies;

    public Director() {
    }

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getDirectorId() {
        return directorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        if (this.movies == null) {
            this.movies = new ArrayList<>(Collections.singletonList(movie));
        } else {
            this.movies.add(movie);
        }
    }
}
