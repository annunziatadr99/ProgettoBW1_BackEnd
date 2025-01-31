package org.example.DAO;

import org.example.Entities.Biglietto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BigliettoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBW1_BackEnd");

    public void save(Biglietto biglietto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(biglietto);
        em.getTransaction().commit();
        em.close();
    }

    public Biglietto findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Biglietto biglietto = em.find(Biglietto.class, id);
        em.close();
        return biglietto;
    }

    public List<Biglietto> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Biglietto> biglietti = em.createQuery("SELEZIONA b PER Biglietto b", Biglietto.class).getResultList();
        em.close();
        return biglietti;
    }
}
