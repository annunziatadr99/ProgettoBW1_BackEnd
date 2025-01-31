package org.example.DAO;

import org.example.Entities.Abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AbbonamentoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBW1_BackEnd");

    public void save(Abbonamento abbonamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(abbonamento);
        em.getTransaction().commit();
        em.close();
    }

    public Abbonamento findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Abbonamento abbonamento = em.find(Abbonamento.class, id);
        em.close();
        return abbonamento;
    }

    public List<Abbonamento> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Abbonamento> abbonamenti = em.createQuery("SELEZIONA a PER Abbonamento a", Abbonamento.class).getResultList();
        em.close();
        return abbonamenti;
    }
}
