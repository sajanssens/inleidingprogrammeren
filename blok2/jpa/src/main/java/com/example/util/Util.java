package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Util {

    private Util() { }

    public static Logger logger(Class<?> c) { return LoggerFactory.getLogger(c); }

}
