package com.example.cdi.high;

import com.example.cdi.App;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import javax.inject.Inject;

import static com.example.cdi.util.Values.OK;
import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoWeld
@AddPackages(App.class)
@AddBeanClasses(Sender.class)
class SenderTest {

    @Inject private Logger log;
    @Inject private Sender sender;

    @Test
    void hello() { log.info("Hello!"); }

    @Test
    void go() {
        String s = sender.sendAll();
        assertThat(s).contains(OK);
    }
}