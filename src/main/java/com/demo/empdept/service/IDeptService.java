package com.demo.empdept.service;

import com.demo.empdept.entity.Dept;
import com.demo.empdept.exceptions.DeptExistedException;

public interface IDeptService {
    boolean createDept(Dept dept) throws DeptExistedException;

    boolean modifyDept(Dept dept);

    boolean deleteDept(int deptId);
}
