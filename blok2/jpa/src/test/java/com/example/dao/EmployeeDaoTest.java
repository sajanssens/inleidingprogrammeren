package com.example.dao;

import com.example.domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeDaoTest {

    @Mock EntityManager emMock;
    @Mock EntityTransaction entityTransactionMock;

    @InjectMocks
    EmployeeDao dao = new EmployeeDao(emMock);

    @BeforeEach
    void setUp() {
        when(emMock.getTransaction()).thenReturn(entityTransactionMock);
        doNothing().when(entityTransactionMock).begin();
        doNothing().when(entityTransactionMock).commit();
    }

    @Test
    void insert() {
        // given: see setup

        // when
        dao.insert(new Employee());

        // then
        verify(emMock).persist(isA(Employee.class));

        verify(emMock, atLeastOnce()).getTransaction();
        verify(entityTransactionMock).begin();
        verify(entityTransactionMock).commit();
    }
}
