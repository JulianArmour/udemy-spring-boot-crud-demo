package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findEmployeeById(int id);

    void saveOrUpdate(Employee employee);

    void deleteById(int id);
}
