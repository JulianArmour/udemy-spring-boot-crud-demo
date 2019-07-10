package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("ALL")
@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDAO {
    private EntityManager entityManager;

    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return  session.createQuery("from Employee", Employee.class).getResultList();
    }
}
