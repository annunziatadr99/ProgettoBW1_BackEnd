package org.example.DAO;

import org.example.Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UtenteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBW1_BackEnd");

    public void save(Utente utente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        em.close();
    }

    public Utente findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Utente utente = em.find(Utente.class, id);
        em.close();
        return utente;
    }

    public List<Utente> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Utente> utenti = em.createQuery("SELEZIONA u PER Utente u", Utente.class).getResultList();
        em.close();
        return utenti;
    }
}
