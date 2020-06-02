package com.example.cdi.util;

import com.example.cdi.high.Sender;
import org.slf4j.Logger;

import javax.inject.Inject;

public class Boot {

    @Inject Logger log;
    @Inject Sender sender;

    public void go() {
        // sender.addSendable(new Email());
        String s = sender.sendAll();
        log.info(s);
    }

}
