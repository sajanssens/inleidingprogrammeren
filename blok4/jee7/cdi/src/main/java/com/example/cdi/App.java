package com.example.cdi;

import com.example.cdi.util.Boot;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class App {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        Boot boot = container.select(Boot.class).get();
        boot.go();
    }
}
