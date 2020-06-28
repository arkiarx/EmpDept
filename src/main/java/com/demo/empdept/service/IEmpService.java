package com.demo.empdept.service;

import com.demo.empdept.entity.Emp;

import java.util.List;

public interface IEmpService {
    boolean createEmp(Emp emp);

    boolean modifyEmp(Emp emp);

    boolean deleteEmp(Long empId);

    List<Emp> listEmp();
}
