package com.demo.empdept.service;

import com.demo.empdept.entity.Dept;
import com.demo.empdept.exceptions.DeptExistedException;
import com.demo.empdept.exceptions.DeptNotFoundException;

public interface IDeptService {
    boolean createDept(Dept dept) throws DeptExistedException;

    boolean modifyDept(Dept dept) throws DeptNotFoundException;

    boolean deleteDept(int deptId) throws DeptNotFoundException;
}
