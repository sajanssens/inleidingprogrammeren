package com.example.dependent.high;

import com.example.dependent.high.Sender;
import org.junit.jupiter.api.Test;

import static com.example.cdi.util.Values.OK;
import static org.assertj.core.api.Assertions.assertThat;

class SenderTest {

    Sender target = new Sender();

    @Test
    void sendAll() {
        // given a target

        // when
        String s = target.sendAll();

        // then
        assertThat(s).contains(OK);
    }

}