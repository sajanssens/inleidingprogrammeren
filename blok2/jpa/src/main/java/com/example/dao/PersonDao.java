package com.example.dao;

import com.example.domain.Persoon;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.example.util.Util.logger;

public class PersonDao {

    private final Logger log = logger(getClass());
    private final EntityManager em;

    public PersonDao(EntityManager em) {
        this.em = em;
    }

    public void insert(Persoon p) {
        em.getTransaction().begin();
        em.persist(p); // in persistence context
        em.getTransaction().commit();
    }

    public Persoon select(int id) {
        log.debug("Finding person with id " + id);
        return em.find(Persoon.class, id); // 1
    }

    public List<Persoon> selectAll() {
        TypedQuery<Persoon> query = em.createQuery("select p from Persoon p", Persoon.class);
        return query.getResultList(); // 2
    }

    public List<Persoon> selectAll(String name) {
        TypedQuery<Persoon> query = em.createQuery("select p from Persoon p where p.naam = :firstarg", Persoon.class);
        query.setParameter("firstarg", name);
        return query.getResultList(); // 3
    }

    public List<Persoon> selectAllNamed() {
        TypedQuery<Persoon> findAll = em.createNamedQuery("findAll", Persoon.class);
        return findAll.getResultList();
    }

    public void delete(int id) {
        Persoon select = select(id);
        if (select != null) {
            em.getTransaction().begin();
            em.remove(select);
            em.getTransaction().commit();
        }
    }

    public Persoon updateFirstname(int id, String name) {
        Persoon p = select(id);
        if (p != null) {
            em.getTransaction().begin();
            p.setNaam(name);
            em.getTransaction().commit();
        }
        return p;
    }

    public Persoon update(Persoon p) {
        em.getTransaction().begin();
        Persoon merged = em.merge(p);
        em.getTransaction().commit();
        return merged;
    }
}
