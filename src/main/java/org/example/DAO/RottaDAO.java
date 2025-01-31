package org.example.DAO;

import org.example.Entities.Rotta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RottaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBW1_BackEnd");

    public void save(Rotta rotta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(rotta);
        em.getTransaction().commit();
        em.close();
    }

    public Rotta findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Rotta rotta = em.find(Rotta.class, id);
        em.close();
        return rotta;
    }

    public List<Rotta> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Rotta> routes = em.createQuery("SELEZIONA r PER Rotta r", Rotta.class).getResultList();
        em.close();
        return routes;
    }
}
