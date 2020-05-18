package com.example.resources;

import com.example.domain.Employee;
import com.example.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeResourceTest {

    @InjectMocks
    private final EmployeeResource target = new EmployeeResource();

    @Mock private EmployeeService serviceMock;
    @Mock private Employee employeeMock;

    @Test
    void whenGetByIdThenEmployeeIsReturned() {
        when(serviceMock.get(anyLong())).thenReturn(employeeMock);

        assertThat(target.get(1L)).isEqualTo(employeeMock);

        verify(serviceMock).get(anyLong());
    }

}