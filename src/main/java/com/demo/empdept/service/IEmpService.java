package com.demo.empdept.service;

import com.demo.empdept.entity.Emp;
import com.demo.empdept.exceptions.EmpNotFoundException;

import java.util.List;

public interface IEmpService {
    boolean createEmp(Emp emp);

    boolean modifyEmp(Emp emp) throws EmpNotFoundException;

    boolean deleteEmp(Long empId) throws EmpNotFoundException;

}
