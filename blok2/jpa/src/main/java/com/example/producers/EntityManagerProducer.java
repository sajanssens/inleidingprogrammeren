package com.example.producers;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Singleton
public class EntityManagerProducer {

    @Produces
    @Named("mysql")
    public static EntityManager mysql() {
        return Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    }

    @Produces
    @Named("h2")
    public static EntityManager h2(/*InjectionPoint injectionPoint*/) {
        return Persistence.createEntityManagerFactory("H2").createEntityManager();
    }

    // public static EntityManager h2() { return Persistence.createEntityManagerFactory("H2").createEntityManager();}
}
