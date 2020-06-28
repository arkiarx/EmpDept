package com.demo.empdept.service.impl;

import com.demo.empdept.entity.Dept;
import com.demo.empdept.exceptions.DeptExistedException;
import com.demo.empdept.repository.IDeptRepostitory;
import com.demo.empdept.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("deptService")
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptRepostitory deptRepository;

    @Override
    public boolean createDept(Dept dept) throws DeptExistedException {
        if(null == dept) return false;
        Optional<Dept> optDept = deptRepository.findById(dept.getDeptId());
        if(optDept.isPresent()){
            throw new DeptExistedException();
        }
        Dept saved = deptRepository.save(dept);
        if(null == saved){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean modifyDept(Dept dept) {
        if(null == dept) return false;
        Optional<Dept> optDept = deptRepository.findById(dept.getDeptId());
        if(optDept.isPresent()){
            Dept curDept = optDept.get();
            curDept.setDeptName(dept.getDeptName());
            deptRepository.save(curDept);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteDept(int deptId) {
        if(deptId <= 0){
            return false;
        }
        Optional<Dept> optDept = deptRepository.findById(deptId);
        if(optDept.isPresent()){
            deptRepository.deleteById(deptId);
            return true;
        }else{
            return false;
        }
    }
}
