package com.example.resources;

import com.example.EntityManagerProducerAlt;
import com.example.dao.EmployeeDao;
import com.example.domain.Employee;
import com.example.services.EmployeeService;
import com.example.util.producers.LoggerProducer;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static com.example.domain.EmployeeValues.BRAM;
import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoWeld
@AddBeanClasses({EmployeesResource.class, EmployeeService.class, EmployeeDao.class, EntityManagerProducerAlt.class, LoggerProducer.class})
@EnableAlternatives(EntityManagerProducerAlt.class)
class EmployeesResourceIT {

    @Inject
    private EmployeesResource resource;

    @Test
    void whenEmployeeIsPostedAndGottenThePostedEmployeeIsReturned() {
        Employee posted = resource.post(BRAM);
        assertThat(posted.getId()).isNotNull();

        Employee gotten = resource.get(posted.getId());
        assertThat(gotten).isEqualTo(posted);
    }

}