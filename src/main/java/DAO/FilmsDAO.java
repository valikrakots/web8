package DAO;

import Connector.Exceptions.JDBCConnectionException;
import DAO.Exceptions.DAOException;
import Models.Film;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class FilmsDAO extends DAO {


    public FilmsDAO() {
        super();
    }


    public List<Film> getAllFilms() throws JDBCConnectionException, DAOException {
        EntityManager entityManager = null;
        List<Film> films = null;

        try {

            entityManager = getEntityManagerFactory().createEntityManager();

            films = entityManager.createNamedQuery("getAllFilms", Film.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return films;
    }

    public List<Film> getFilmsWithGoodRating() throws JDBCConnectionException, DAOException {
        EntityManager entityManager = null;
        List<Film> films = null;

        try {

            entityManager = getEntityManagerFactory().createEntityManager();

            films = entityManager.createNamedQuery("getFilmsWithGoodRaiting", Film.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return films;
    }

    public void insertFilm(int id, String title, String created, String country, double raiting, String dir) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(new Film(id,title,created,country,raiting,dir));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteFilm(int id){
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.createNamedQuery("deleteFilm").setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
