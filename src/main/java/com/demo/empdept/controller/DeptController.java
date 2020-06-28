package com.demo.empdept.controller;

import com.demo.empdept.entity.Dept;
import com.demo.empdept.exceptions.DeptExistedException;
import com.demo.empdept.model.ResultMessage;
import com.demo.empdept.service.IDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/dept")
@Controller
public class DeptController {

    private Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private IDeptService deptService;

    @PostMapping("/add")
    @ResponseBody
    public ResultMessage addDept(@RequestBody Dept dept){
        ResultMessage msg = new ResultMessage();
        boolean bFlag = false;
        try {
            deptService.createDept(dept);
            msg.setErrCode(100);
            msg.setErrMsg("success");
        }catch(DeptExistedException ex){
            msg.setErrCode(-900);
            msg.setErrMsg(ex.getMessage());
        }catch(Exception ex){
            msg.setErrCode(-999);
            msg.setErrMsg("failed");
        }

        return msg;
    }

    @PostMapping("/update")
    @ResponseBody
    public ResultMessage updateDept(@RequestBody Dept dept){
        ResultMessage msg = new ResultMessage();
        boolean bFlag = deptService.modifyDept(dept);
        if(bFlag){
            msg.setErrCode(100);
            msg.setErrMsg("success");
        }else{
            msg.setErrCode(-999);
            msg.setErrMsg("failed");
        }
        return msg;
    }

    @GetMapping("/del/{deptId}")
    @ResponseBody
    public ResultMessage delDept(@PathVariable("deptId") int deptId){
        ResultMessage msg = new ResultMessage();
        boolean bFlag = deptService.deleteDept(deptId);
        if(bFlag){
            msg.setErrCode(100);
            msg.setErrMsg("success");
        }
        else{
            msg.setErrCode(-999);
            msg.setErrMsg("failed");
        }
        return msg;
    }
}
