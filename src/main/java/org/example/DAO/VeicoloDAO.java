package org.example.DAO;

import org.example.Entities.Veicolo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class VeicoloDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBW1_BackEnd");

    public void save(Veicolo veicolo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(veicolo);
        em.getTransaction().commit();
        em.close();
    }

    public Veicolo findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Veicolo veicolo = em.find(Veicolo.class, id);
        em.close();
        return veicolo;
    }

    public List<Veicolo> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Veicolo> veicoli = em.createQuery("SELECT v FROM Veicolo v", Veicolo.class).getResultList();
        em.close();
        return veicoli;
    }
}