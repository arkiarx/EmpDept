package com.demo.empdept.repository;

import com.demo.empdept.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("empRepository")
public interface IEmpRepository extends JpaRepository<Emp, Long> {

}
