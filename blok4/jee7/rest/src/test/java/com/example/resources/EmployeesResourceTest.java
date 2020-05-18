package com.example.resources;

import com.example.domain.Employee;
import com.example.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeesResourceTest {

    @InjectMocks
    private final EmployeesResource target = new EmployeesResource();

    @Mock private EmployeeService serviceMock;
    @Mock private Employee employeeMock;

    @Test
    void whenGetByIdThenEmployeeIsReturned() {
        when(serviceMock.get(anyLong())).thenReturn(employeeMock);

        assertThat(target.get(1L)).isEqualTo(employeeMock);

        verify(serviceMock).get(anyLong());
    }

    @Test
        // @Disabled
    void whenGetAllThenEmployeesAreReturned() {
        when(serviceMock.get()).thenReturn(Arrays.asList(employeeMock, employeeMock, employeeMock));

        assertThat(target.getAll().size()).isEqualTo(3);

        verify(serviceMock).get();
    }

}