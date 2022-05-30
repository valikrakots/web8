package DAO;

import Connector.Exceptions.JDBCConnectionException;
import DAO.Exceptions.DAOException;
import Models.Actor;
import Models.Film;
import com.mysql.cj.conf.ConnectionUrlParser;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorsDAO extends DAO {


    public ActorsDAO(){
        super();
    }


    public List<Actor> getActorsOfFilm(String film_name) throws JDBCConnectionException, DAOException {

        EntityManager entityManager = null;
        List<Actor> actors = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            actors = entityManager.createNamedQuery("getAllActorsOfFilm", Actor.class).setParameter("Title", film_name).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return actors;
    }

    public List<Actor> getActorsWithOneOrMoreFilms() throws JDBCConnectionException, DAOException {

        EntityManager entityManager = null;
        List<Actor> actors = null;


        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            actors = entityManager.createNamedQuery("getAllActorsOneOrMoreFilm", Actor.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return actors;
    }





}
