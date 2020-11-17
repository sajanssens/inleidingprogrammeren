package com.example.dao;

import com.example.domain.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeDaoTest {

    @Mock Logger log;
    @Mock EntityManager emMock;
    @Mock EntityTransaction entityTransactionMock;

    @InjectMocks
    EmployeeDao dao = new EmployeeDao();

    @Test
    void whenInsertIsCalledATransactionIsBegunAndPersistIsCalledAndCommitted() {
        // given
        when(emMock.getTransaction()).thenReturn(entityTransactionMock);
        doNothing().when(entityTransactionMock).begin();
        doNothing().when(entityTransactionMock).commit();

        // when
        dao.insert(new Employee());

        // then
        verify(emMock).persist(isA(Employee.class));

        verify(emMock, atLeastOnce()).getTransaction();
        verify(entityTransactionMock).begin();
        verify(entityTransactionMock).commit();
    }

    @Test
    void whenSelectIsCalledFindIsExecutedWithoutTransactionAndResultIsCorrect() {
        // given
        Employee mock = mock(Employee.class);
        when(emMock.find(any(), anyLong())).thenReturn(mock);

        // when
        Employee select = dao.select(1L);

        // then
        verify(emMock).find(any(), eq(1L));

        verify(emMock, never()).getTransaction();
        verify(entityTransactionMock, never()).begin();
        verify(entityTransactionMock, never()).commit();

        assertThat(select).isEqualTo(mock);
    }

    @Mock TypedQuery<Employee> query;
    @Mock Employee e;
    List<Employee> employees = Arrays.asList(e, e, e);

    @Test
    void selectAll() {
        when(emMock.createQuery(anyString(), eq(Employee.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(employees);

        List<Employee> all = dao.selectAll();
        assertThat(all.size()).isEqualTo(3);
    }
}
