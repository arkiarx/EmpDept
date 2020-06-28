package com.demo.empdept.service;

import com.demo.empdept.entity.EmpDept;
import com.demo.empdept.model.QueryModel;

import java.util.List;

public interface IEmpDeptService {
    List<EmpDept> listEmpDeptPage(QueryModel qModel, int page);
}
