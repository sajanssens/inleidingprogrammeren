package com.example.dao;

import com.example.domain.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeDaoTest {

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
}
