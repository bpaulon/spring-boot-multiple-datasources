package com.foobar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.foobar.bar.domain.Bar;
import com.foobar.bar.domain.BarAutoID;
import com.foobar.bar.repo.BarAutoIDRepository;
import com.foobar.bar.repo.BarRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BarRepositoryTest {

  @Autowired
  private TestEntityManager em;

  @Autowired
  private BarRepository barRepo;
  
  @Autowired
  private BarAutoIDRepository barAutoIdRepo;
  
  @Test
  public void testPersist() {
    Bar b1 = new Bar("aa");
    em.persist(b1);
    System.out.println(barRepo.findById(1L));
  }
  
  @Test
  public void testPersistAuto() {
    BarAutoID bid1 = new BarAutoID();
    em.persist(bid1);
  }
}
