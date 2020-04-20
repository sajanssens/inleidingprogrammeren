package com.example.dao;

import com.example.domain.Person;

import javax.persistence.EntityManager;

public class PersonDao {

    private final EntityManager em;

    public PersonDao(EntityManager em) {
        this.em = em;
    }

    public Person getPerson(int id) {
        return em.find(Person.class, id);
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

    public void insert(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

}
