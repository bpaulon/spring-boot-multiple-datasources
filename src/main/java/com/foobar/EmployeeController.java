package com.foobar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foobar.employee.Employee;
import com.foobar.employee.EmployeeRepository;

@RestController
public class EmployeeController {

  @Autowired
  EmployeeRepository employeeRepo;
  
  @Transactional
  @RequestMapping("/employee")
  public void addEmployee() {
    Employee saved= employeeRepo.save(new Employee());
    System.out.println(saved);
  }
}
