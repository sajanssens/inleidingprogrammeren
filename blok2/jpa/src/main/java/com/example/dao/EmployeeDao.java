package com.example.dao;

import com.example.domain.Employee;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDao implements IEmployeeDao {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public EmployeeDao() { }

    public EmployeeDao(EntityManager em) { this.em = em; }

    public void insert(Employee p) {
        em.getTransaction().begin();
        em.persist(p); // in persistence context
        em.getTransaction().commit();
        em.detach(p);
    }

    public Employee select(long id) {
        log.debug("Finding Employee with id " + id);
        Employee employee = em.find(Employee.class, id);
        if (employee != null) em.detach(employee);
        return employee; // 1
    }

    public List<Employee> selectAll() {
        TypedQuery<Employee> query = em.createQuery("select p from Employee p", Employee.class);
        return query.getResultList(); // 2
    }

    public List<Employee> selectOnlyEmployees() {
        TypedQuery<Employee> query = em.createQuery("select p from Employee p where type(e) = ", Employee.class);
        return query.getResultList(); // 2
    }

    public List<Employee> selectAll(String name) {
        TypedQuery<Employee> query = em.createQuery("select p from Employee p where p.naam = :firstarg", Employee.class);
        query.setParameter("firstarg", name);
        return query.getResultList(); // 3
    }

    public List<Employee> findByPhone(long phoneId) {
        TypedQuery<Employee> query = em.createQuery(
                "SELECT p " +
                        "FROM Employee p " +
                        "JOIN p.phones ps " +
                        "WHERE ps.id = :phoneId",
                Employee.class);
        query.setParameter("phoneId", phoneId);
        return query.getResultList(); // findBy on OneToMany (with join)
    }

    public List<Employee> selectAllNamed() {
        TypedQuery<Employee> findAll = em.createNamedQuery("findAll", Employee.class);
        return findAll.getResultList();
    }

    public void delete(Long id) {
        Employee select = em.find(Employee.class, id);
        if (select != null) {
            em.getTransaction().begin();
            em.remove(select);
            em.getTransaction().commit();
        }
    }

    public Employee updateFirstname(int id, String name) {
        Employee p = select(id);
        if (p != null) {
            em.getTransaction().begin();
            p.setNaam(name);
            em.getTransaction().commit();
        }
        return p;
    }

    public Employee update(Employee p) {
        em.getTransaction().begin();
        Employee merged = em.merge(p);
        em.getTransaction().commit();
        return merged;
    }

    public List<Employee> findEmployees(boolean eager) {
        String fetch = eager ? "FETCH" : "";

        return em.createQuery(
                "SELECT DISTINCT emp " +
                        "FROM Employee emp " +
                        "JOIN " + fetch + " emp.phones", Employee.class)
                .getResultList();
    }

    public List<Tuple> findEmployeeDepartments() {
        return em.createQuery(
                "SELECT new com.example.dao.Tuple(emp.naam, dep.name) " +
                        "FROM Employee emp " +
                        "JOIN emp.worksAtDepartments dep", Tuple.class)
                .getResultList();
    }

    // Criteria API ---------

    public List<Employee> findUsingCriteriaAPI(String name, String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> q = cb.createQuery(Employee.class);

        Root<Employee> emp = q.from(Employee.class);

        q.select(emp).distinct(true)
                .where(cb.or(
                        cb.equal(emp.get("naam"), name),
                        cb.equal(emp.get("emailAddress"), email)
                        )
                );

        return em.createQuery(q).getResultList();
    }

}
