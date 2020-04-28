package com.example.dao;

import com.example.domain.Employee;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.example.util.Util.logger;

public class EmployeeDao {

    private final Logger log = logger(getClass());
    private EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    public void insert(Employee p) {
        em.getTransaction().begin();
        em.persist(p); // in persistence context
        em.getTransaction().commit();
    }

    public Employee select(int id) {
        log.debug("Finding Employee with id " + id);
        return em.find(Employee.class, id); // 1
    }

    public List<Employee> selectAll() {
        TypedQuery<Employee> query = em.createQuery("select p from Employee p", Employee.class);
        return query.getResultList(); // 2
    }

    public List<Employee> selectAll(String name) {
        TypedQuery<Employee> query = em.createQuery("select p from Employee p where p.naam = :firstarg", Employee.class);
        query.setParameter("firstarg", name);
        return query.getResultList(); // 3
    }

    public List<Employee> selectAllNamed() {
        TypedQuery<Employee> findAll = em.createNamedQuery("findAll", Employee.class);
        return findAll.getResultList();
    }

    public void delete(int id) {
        Employee select = select(id);
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

    public List<Employee> findEmployees() {
        return em.createQuery(
                "SELECT emp " +
                        "FROM Employee emp " +
                        "JOIN emp.worksAtDepartments", Employee.class)
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
                .where(cb.and(
                        cb.equal(emp.get("name"), name),
                        cb.equal(emp.get("email"), email)
                        )
                );

        return em.createQuery(q).getResultList();
    }

}
