package com.foobar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foobar.foo.domain.Foo;
import com.foobar.foo.repo.FooRepository;

@RestController
@Profile("mysql")
public class MySqlFooController {

  @Autowired
  private FooRepository fooRepo;

  @RequestMapping("/foo")
  public Foo addFoo() {
    return fooRepo.save(new Foo("aaa"));
  }
}
