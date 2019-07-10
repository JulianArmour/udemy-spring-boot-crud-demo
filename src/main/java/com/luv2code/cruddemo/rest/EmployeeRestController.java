package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.dao.EmployeeDAO;
import com.luv2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @GetMapping("/employees")
    public List<Employee> employees() {
        System.out.println("Hi!");
        return employeeDAO.findAll();
    }
}
