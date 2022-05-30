package DAO;

import DAO.Exceptions.DAOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class DAO {

    private EntityManagerFactory factory;

    /**
     * Constructor
     * @throws DAOException exception
     */
    DAO() {
        this.factory = Persistence.createEntityManagerFactory("default");
        String s = "";
    }

    protected EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }

}
