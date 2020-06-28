package com.demo.empdept.repository;

import com.demo.empdept.entity.EmpDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("empDeptRepository")
public interface IEmpDeptRepository extends JpaRepository<EmpDept, Long>, JpaSpecificationExecutor<EmpDept> {

}
