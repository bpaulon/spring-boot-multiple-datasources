package com.foobar.bar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foobar.bar.domain.BarAutoID;

@Repository
public interface BarAutoIDRepository  extends JpaRepository<BarAutoID, Long> {

  BarAutoID findById(Long id);

}
