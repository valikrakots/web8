package DAO;


//import Models.Auth;

import Models.Actor;
import Models.Auth;
import Models.Film;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManager;
import java.util.List;

public class AuthorizationDAO extends DAO{

    public Auth login(String login, String password){
        Auth user = null;
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            user = entityManager.createNamedQuery("getLogin", Auth.class).setParameter("login", login).setParameter("password",password).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return user;
    }

    public boolean loginHandler(String login){
        Auth user = null;
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            user = entityManager.createNamedQuery("getUser", Auth.class).setParameter("login", login).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        if (user != null) {
            return true;
        }
        return false;
    }

    public void createAccount(Auth user) {
        EntityManager entityManager = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
}
