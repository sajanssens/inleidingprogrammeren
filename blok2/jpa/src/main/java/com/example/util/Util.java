package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public final class Util {

    private Util() { }

    public static Logger logger(Class<?> c) { return LoggerFactory.getLogger(c); }

    public static EntityManager mysql() { return Persistence.createEntityManagerFactory("MySQL").createEntityManager();}

    public static EntityManager h2() { return Persistence.createEntityManagerFactory("H2").createEntityManager();}

}
