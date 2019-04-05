package com.foobar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foobar.employee.Employee;
import com.foobar.employee.EmployeeRepository;

@RestController
public class EmployeeController {
  
  @Autowired
  EmployeeRepository employeeRepo;
  
  @RequestMapping("/employee")
  public Employee addEmployee() {
    return employeeRepo.save(new Employee());
  }
  
}
