package org.example.DAO;

import org.example.Entities.DistributoreAutomatico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DistributoreAutomaticoDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBW1_BackEnd");

    public static void save(DistributoreAutomatico distributoreAutomatico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(distributoreAutomatico);
        em.getTransaction().commit();
        em.close();
    }

    public DistributoreAutomatico findById(Long id) {
        EntityManager em = emf.createEntityManager();
        DistributoreAutomatico distributoreAutomatico = em.find(DistributoreAutomatico.class, id);
        em.close();
        return distributoreAutomatico;
    }

    public List<DistributoreAutomatico> findAll() {
        EntityManager em = emf.createEntityManager();
        List<DistributoreAutomatico> distributoriAutomatici = em.createQuery("SELEZIONA da PER DistributoreAutomatico da", DistributoreAutomatico.class).getResultList();
        em.close();
        return distributoriAutomatici;
}
}
