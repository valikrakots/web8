package Models;

import javax.persistence.*;

/**
 * class that represent film entity
 */
@Entity
@Table(name = "films")
@NamedQueries({
        @NamedQuery(name = "getAllFilms",
                query = "select f from Film f"),
        @NamedQuery(name = "getFilmsWithGoodRaiting",
                query = "SELECT f FROM Film f WHERE f.raiting > 8.0"),
        @NamedQuery(name="deleteFilm",
        query="delete from Film f WHERE f.film_id = :id")
})
public class Film {

    @Id
    @Column(name = "film_id")
    private int film_id;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "created")
    private String created;

    @Basic
    @Column(name = "country")
    private String country;

    @Basic
    @Column(name = "raiting")
    private double raiting;

    @Basic
    @Column(name = "dir_id")
    private String director;

    public Film() {

    }

    public void setID(int ID) {
        this.film_id = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setRaiting(double raiting) {
        this.raiting = raiting;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getID() {
        return film_id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreated() {
        return created;
    }

    public double getRaiting() {
        return raiting;
    }

    public String getCountry() {
        return country;
    }

    public String getDirector() {
        return director;
    }

    public Film(Integer id, String title, String created, String country, double raiting, String director){
        setCountry(country);
        setCreated(created);
        setDirector(director);
        setID(id);
        setRaiting(raiting);
        setTitle(title);
    }

    @Override
    public String toString() {
        return "\n### FILM INFORMATION ###\n" +
                "ID = " + getID() + "\n" +
                "Film's name: " + getTitle() + "\n" +
                "Created: " + getCreated() + "\n" +
                "Raiting: " + getRaiting() + "\n" +
                "Country: " + getCountry() + "\n" +
                "Director: " + getDirector();
    }
}
