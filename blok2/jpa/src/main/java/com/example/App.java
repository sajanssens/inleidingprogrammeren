package com.example;

import com.example.dao.PersonDao;
import com.example.domain.Persoon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    private Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        log.error("TEST"); // serr
        log.info("Starting app...");

        // application managed persistence context
        EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
        EntityManager em = mySQL.createEntityManager();

        PersonDao dao = new PersonDao(em);
        Persoon bram = new Persoon("Bram", 42);
        // bram.setEmailaddress("bram@test.com");

        dao.insert(bram);
        Persoon persoon = dao.select(1);
        log.debug(persoon.toString()); // sout

        dao.selectAll().forEach(System.out::println);
        dao.selectAll("Michael").forEach(System.out::println);

        dao.delete(3);
        dao.selectAll().forEach(System.out::println);

        Persoon gert_jan = dao.updateFirstname(1, "Gert Jan");
        dao.selectAll().forEach(System.out::println);

    }
}
