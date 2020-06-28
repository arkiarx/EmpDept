package com.demo.empdept.service.impl;

import com.demo.empdept.entity.Emp;
import com.demo.empdept.repository.IEmpRepository;
import com.demo.empdept.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service("empService")
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private IEmpRepository empRepository;

    @Override
    public boolean createEmp(Emp emp) {
        if(null == emp) {
            return false;
        }
        Emp curEmp = empRepository.save(emp);
        if(null != curEmp) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyEmp(Emp emp) {
        if(null == emp) return false;
        Optional<Emp> optionalEmp = empRepository.findById(emp.getEmpId());
        if(optionalEmp.isPresent()){

            Emp curEmp = optionalEmp.get();
            curEmp.setAddress(emp.getAddress());
            curEmp.setAge(emp.getAge());
            curEmp.setDeptId(emp.getDeptId());
//            curEmp.setDept(emp.getDept());
            curEmp.setEmpName(emp.getEmpName());
            curEmp.setGender(emp.getGender());
            curEmp.setMobile(emp.getMobile());
//            curEmp.setUpdateTime();

            empRepository.save(curEmp);
        }
        return false;
    }

    @Override
    public boolean deleteEmp(Long empId) {
        if(0 >= empId) return false;
        Optional<Emp> optEmp = empRepository.findById(empId);
        if(optEmp.isPresent()){
            empRepository.deleteById(empId);
            return true;
        }
        return false;
    }

    @Override
    public List<Emp> listEmp() {
        return empRepository.findAll();
    }
}
