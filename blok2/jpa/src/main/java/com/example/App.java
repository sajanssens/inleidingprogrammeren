package com.example;

import com.example.dao.PersonDao;
import com.example.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

        PersonDao dao = new PersonDao(em);

        dao.insert(new Person("Bram", 42));
        Person person = dao.getPerson(1);
        System.out.println(person);
    }
}
