package com.demo.empdept.repository;

import com.demo.empdept.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("deptRepository")
public interface IDeptRepostitory extends JpaRepository<Dept, Integer> {

}
