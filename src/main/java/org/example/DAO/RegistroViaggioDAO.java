package org.example.DAO;

import org.example.Entities.RegistroViaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RegistroViaggioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBW1_BackEnd");

    public void save(RegistroViaggio registroViaggio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(registroViaggio);
        em.getTransaction().commit();
        em.close();
    }

    public RegistroViaggio findById(Long id) {
        EntityManager em = emf.createEntityManager();
        RegistroViaggio registroViaggio = em.find(RegistroViaggio.class, id);
        em.close();
        return registroViaggio;
    }

    public List<RegistroViaggio> findAll() {
        EntityManager em = emf.createEntityManager();
        List<RegistroViaggio> registroViaggi = em.createQuery("SELEZIONA rv PER RegistroViaggio rv", RegistroViaggio.class).getResultList();
        em.close();
        return registroViaggi;
    }
}
