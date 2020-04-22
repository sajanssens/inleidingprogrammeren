package com.example.dao;

import com.example.domain.Persoon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonDao {

    Logger log = LoggerFactory.getLogger(PersonDao.class);

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
        return em.find(Persoon.class, id);
    }

    public List<Persoon> selectAll() {
        TypedQuery<Persoon> query = em.createQuery("select p from Persoon p", Persoon.class);
        return query.getResultList();
    }

    public List<Persoon> selectAll(String name) {
        TypedQuery<Persoon> query = em.createQuery("select p from Persoon p where p.naam = :firstarg", Persoon.class);
        query.setParameter("firstarg", name);
        return query.getResultList();
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

    // public List<Person> getPersonsWithGender() {
    //
    // }

    // public List<Person> getPersonsByName(String name) throws SQLException {
    //
    // }

}
