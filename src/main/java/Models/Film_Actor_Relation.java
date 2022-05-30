package Models;

import javax.persistence.*;

@Entity
@Table(name = "film_actor_relation")
public class Film_Actor_Relation {

    @Id
    @Column(name = "film_id")
    private Integer film_id;


    @Column(name = "actor_id")
    private Integer actor_id;

    public Film_Actor_Relation(Integer film_id, Integer actor_id){
        setActor_id(actor_id);
        setFilm_id(film_id);
    }

    public Film_Actor_Relation() {

    }

    public void setActor_id(Integer actor_id) {
        this.actor_id = actor_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }
}
