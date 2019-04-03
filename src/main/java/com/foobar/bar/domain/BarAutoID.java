package com.foobar.bar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "bar_auto")
public class BarAutoID {

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  //@GenericGenerator(name = "native", strategy = "native")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;
  
  @Column(name = "BAR")
  private String bar;
  
  public BarAutoID() {
    // Default constructor needed by JPA
  }

  public String getBar() {
    return bar;
  }
}
