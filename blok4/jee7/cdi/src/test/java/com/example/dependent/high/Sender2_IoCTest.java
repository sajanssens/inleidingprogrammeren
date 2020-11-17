package com.example.dependent.high;

import com.example.dependent.high.Sender2_IoC;
import com.example.dependent.low.Email;
import com.example.dependent.low.Sms;
import org.junit.jupiter.api.Test;

import static com.example.cdi.util.Values.OK;
import static org.assertj.core.api.Assertions.assertThat;

class Sender2_IoCTest {

    Sender2_IoC target = new Sender2_IoC();

    @Test
    void sendAll() {
        // given
        target.setEmail(new Email());
        target.setSms(new Sms());

        // when
        String s = target.sendAll();

        // then
        assertThat(s).contains(OK);
    }

}