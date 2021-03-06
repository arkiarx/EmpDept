package com.demo.empdept.controller;

import com.demo.empdept.entity.Dept;
import com.demo.empdept.exceptions.DeptExistedException;
import com.demo.empdept.exceptions.DeptNotFoundException;
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
            bFlag = deptService.createDept(dept);
            if(bFlag) {
                msg.setErrCode(100);
                msg.setErrMsg("success");
            }else{
                msg.setErrCode(-999);
                msg.setErrMsg("parameter illegal");
            }
        }catch(DeptExistedException ex){
            msg.setErrCode(-999);
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
        boolean bFlag = false;
        try{
            bFlag = deptService.modifyDept(dept);
        }catch(DeptNotFoundException ex){
            msg.setErrCode(-999);
            msg.setErrMsg(ex.getMessage());
        }catch(Exception ex){
            msg.setErrCode(-999);
            msg.setErrMsg("failed");
        }
        if(bFlag){
            msg.setErrCode(100);
            msg.setErrMsg("success");
        }else{
            msg.setErrCode(-999);
            msg.setErrMsg("parameter illegal");
        }
        return msg;
    }

    @GetMapping("/del/{deptId}")
    @ResponseBody
    public ResultMessage delDept(@PathVariable("deptId") int deptId){
        ResultMessage msg = new ResultMessage();
        boolean bFlag = false;
        try{
            bFlag = deptService.deleteDept(deptId);
        }catch(DeptNotFoundException ex){
            msg.setErrCode(-999);
            msg.setErrMsg(ex.getMessage());
        }catch(Exception ex){
            msg.setErrCode(-999);
            msg.setErrMsg("failed");
        }
        if(bFlag){
            msg.setErrCode(100);
            msg.setErrMsg("success");
        }
        else{
            msg.setErrCode(-999);
            msg.setErrMsg("parameter illegal");
        }
        return msg;
    }
}
