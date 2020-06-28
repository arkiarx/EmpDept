package com.demo.empdept.service.impl;

import com.demo.empdept.entity.Emp;
import com.demo.empdept.exceptions.EmpNotFoundException;
import com.demo.empdept.repository.IEmpRepository;
import com.demo.empdept.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        empRepository.save(emp);
        return true;
    }

    @Override
    public boolean modifyEmp(Emp emp) throws EmpNotFoundException {
        if(null == emp) return false;
        Optional<Emp> optionalEmp = empRepository.findById(emp.getEmpId());
        if(optionalEmp.isPresent()){

            Emp curEmp = optionalEmp.get();
            curEmp.setAddress(emp.getAddress());
            curEmp.setAge(emp.getAge());
            curEmp.setDeptId(emp.getDeptId());
            curEmp.setEmpName(emp.getEmpName());
            curEmp.setGender(emp.getGender());
            curEmp.setMobile(emp.getMobile());
            curEmp.setUpdateTime(new Timestamp(System.currentTimeMillis()));

            empRepository.save(curEmp);
            return true;
        }else{
            throw new EmpNotFoundException();
        }
    }

    @Override
    public boolean deleteEmp(Long empId) throws EmpNotFoundException{
        if(0 >= empId) return false;
        Optional<Emp> optEmp = empRepository.findById(empId);
        if(optEmp.isPresent()){
            empRepository.deleteById(empId);
            return true;
        }else{
            throw new EmpNotFoundException();
        }
    }
}
