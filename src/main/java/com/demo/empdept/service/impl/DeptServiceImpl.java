package com.demo.empdept.service.impl;

import com.demo.empdept.entity.Dept;
import com.demo.empdept.exceptions.DeptExistedException;
import com.demo.empdept.exceptions.DeptNotFoundException;
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
        deptRepository.save(dept);
        return true;
    }

    @Override
    public boolean modifyDept(Dept dept) throws DeptNotFoundException {
        if(null == dept) return false;
        Optional<Dept> optDept = deptRepository.findById(dept.getDeptId());
        if(optDept.isPresent()){
            Dept curDept = optDept.get();
            curDept.setDeptName(dept.getDeptName());
            deptRepository.save(curDept);
            return true;
        }else{
            throw new DeptNotFoundException();
        }
    }

    @Override
    public boolean deleteDept(int deptId) throws DeptNotFoundException{
        if(deptId <= 0){
            return false;
        }
        Optional<Dept> optDept = deptRepository.findById(deptId);
        if(optDept.isPresent()){
            deptRepository.deleteById(deptId);
            return true;
        }else{
            throw new DeptNotFoundException();
        }
    }
}
