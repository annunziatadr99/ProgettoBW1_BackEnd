package org.example.DAO;

import org.example.Entities.RivenditoreAutorizzato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RivenditoreAutorizzatoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBW1_BackEnd");

    public void save(RivenditoreAutorizzato rivenditoreAutorizzato) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(rivenditoreAutorizzato);
        em.getTransaction().commit();
        em.close();
    }

    public RivenditoreAutorizzato findById(Long id) {
        EntityManager em = emf.createEntityManager();
        RivenditoreAutorizzato rivenditoreAutorizzato = em.find(RivenditoreAutorizzato.class, id);
        em.close();
        return rivenditoreAutorizzato;
    }

    public List<RivenditoreAutorizzato> findAll() {
        EntityManager em = emf.createEntityManager();
        List<RivenditoreAutorizzato> rivenditoriAutorizzati = em.createQuery("SELEZIONA ra PER RivenditoreAutorizzato ra", RivenditoreAutorizzato.class).getResultList();
        em.close();
        return rivenditoriAutorizzati;
    }
}
