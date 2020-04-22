package com.example;

import com.example.dao.PersonDao;
import com.example.domain.Persoon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App {

    private Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        log.error("TEST"); // serr

        log.debug("Starting app...");
        EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

        PersonDao dao = new PersonDao(em);

        Persoon bram5678901 = new Persoon("Bram5678901", 42);
        bram5678901.setEmailaddress("bram@test.com");
        dao.insert(bram5678901);

        Persoon persoon = dao.getPerson(1);
        log.debug(persoon.toString()); // sout
    }
}
