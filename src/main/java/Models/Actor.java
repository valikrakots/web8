package Models;


import javax.persistence.*;

@Entity
@Table(name = "actors")
@NamedQueries({
        @NamedQuery(name = "getAllActorsOfFilm",
                query = "SELECT a FROM Actor a WHERE a.ID IN (SELECT fa.actor_id " +
                        "FROM Film_Actor_Relation fa WHERE fa.film_id = (SELECT f.film_id from Film f WHERE f.title = :Title))"),
        @NamedQuery(name = "getAllActorsOneOrMoreFilm",
            query = "SELECT a from Actor a WHERE a.dir is not null"),
})
public class Actor {
    @Id
    @Column(name = "actor_id")
    private int ID;

    @Basic
    @Column(name = "fio")
    private String fio;

    @Basic
    @Column(name = "birthdate")
    private String birth;

    @Basic
    @Column(name = "dir_id")
    private Integer dir;

    public Actor() {

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDir(Integer dir) {
        this.dir = dir;
    }

    public int getID() {
        return ID;
    }

    public String getBirth() {
        return birth;
    }

    public String getFio() {
        return fio;
    }

    public Integer getDir() {
        return dir;
    }

    public Actor(int id, String fio, String birth, Integer dir) {
        setDir(dir);
        setBirth(birth);
        setFio(fio);
        setID(id);
    }
    @Override
    public String toString() {
        return "\n### ACTOR INFORMATION ###\n" +
                "ID = " + getID() + "\n" +
                "Name: \"" + getFio() + "\"\n" +
                "Birthdate: " + getBirth() + "\n";
    }
}
