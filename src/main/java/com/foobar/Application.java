package com.foobar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String... args) {
    System.out.println(System.getProperties());
    
    // Add the connected database type to the spring active profiles. 
    // The existing database profiles are "mysql" and "postgres" 
    String connectedDatabase = "postgres";
    if (args != null && args.length > 0) {
      connectedDatabase = args[0];
    }
    System.setProperty("connected.database", connectedDatabase);

    SpringApplication.run(Application.class, args);
  }
}
