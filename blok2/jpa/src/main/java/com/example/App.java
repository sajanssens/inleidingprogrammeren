package com.example;

import com.example.dao.PersonDao;
import com.example.domain.Persoon;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static com.example.util.Util.logger;

public class App {

    private final Logger log = logger(getClass());

    // application managed persistence context
    private EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        log.error("TEST"); // serr
        log("Starting app...");

        PersonDao dao = new PersonDao(em);
        Persoon bram = new Persoon("Bram", 42);
        // bram.setEmailaddress("bram@test.com");

        dao.insert(bram);

        Persoon persoon = dao.select(1);
        log(persoon);

        dao.selectAll().forEach(this::log);

        List<Persoon> michaels = dao.selectAll("Michael");
        michaels.forEach(this::log);

        dao.delete(3);
        dao.selectAll().forEach(this::log);

        Persoon p2 = dao.updateFirstname(1, "Gert Jan");
        dao.selectAll().forEach(this::log);

        p2.setNaam("Nino");
        Persoon updated = dao.update(p2);

        log(isManaged(p2));
        log(isManaged(updated));

        dao.selectAllNamed().forEach(this::log);
    }

    private void log(Object o) { log.info(o + ""); }

    private boolean isManaged(Persoon p) { return em.contains(p); }
}