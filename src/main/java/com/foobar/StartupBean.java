package com.foobar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.foobar.employee.Employee;
import com.foobar.employee.EmployeeRepository;

@Component
public class StartupBean implements CommandLineRunner {

  @Value("${connected.database}")
  private String connectedDatabase;
  
  @Autowired
  private Environment env;
  
  @Autowired
  EmployeeRepository empRepo;
  
  @Override
  public void run(String... arg0) throws Exception {
    System.out.println("adding employee to connected.database:" + connectedDatabase + " datasource.url:" + env.getProperty("datasource.url"));
    Employee emp = empRepo.save(new Employee());
    System.out.println(emp);
  }

}
