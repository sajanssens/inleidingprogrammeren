package com.example.dao;

import com.example.domain.Persoon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class PersonDao {

    Logger log = LoggerFactory.getLogger(PersonDao.class);

    private final EntityManager em;

    public PersonDao(EntityManager em) {
        this.em = em;
    }

    public Persoon getPerson(int id) {
        log.debug("Finding person with id " + id);
        return em.find(Persoon.class, id);
    }

    // public List<Person> getPersons() {
    //     em.find
    // }

    // public List<Person> getPersonsWithGender() {
    //
    // }

    // public List<Person> getPersonsByName(String name) throws SQLException {
    //
    // }

    public void insert(Persoon p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

}
