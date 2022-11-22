package org.example.mindi.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    int movieId;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    Director director;

    @Column(name = "name")
    String name;

    @Column(name = "year_of_production")
    int yearOfProduction;

    public Movie() {
    }

    public Movie(String name, int yearOfProduction) {
        this.name = name;
        this.yearOfProduction = yearOfProduction;
    }

    public int getMovieId() {
        return movieId;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public String toString() {
        return "Movie name: " + this.name + ", Movie year: " + this.yearOfProduction;
    }
}
