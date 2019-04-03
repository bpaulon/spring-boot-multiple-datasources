package com.foobar;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foobar.bar.domain.Bar;
import com.foobar.bar.domain.BarAutoID;
import com.foobar.bar.repo.BarAutoIDRepository;
import com.foobar.bar.repo.BarRepository;
import com.foobar.employee.Employee;
import com.foobar.employee.EmployeeRepository;
import com.foobar.foo.domain.Foo;
import com.foobar.foo.repo.FooRepository;

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
