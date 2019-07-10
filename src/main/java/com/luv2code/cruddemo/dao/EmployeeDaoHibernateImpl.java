package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@SuppressWarnings("ALL")
@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDAO {
    private EntityManager entityManager;

    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return  session.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findEmployeeById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        entityManager.unwrap(Session.class).saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        entityManager.unwrap(Session.class).createQuery(
        "delete from Employee where id = :id",
            Employee.class
        ).executeUpdate();
    }
}
