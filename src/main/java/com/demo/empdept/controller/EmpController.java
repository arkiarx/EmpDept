package com.demo.empdept.controller;

import com.demo.empdept.entity.Emp;
import com.demo.empdept.exceptions.EmpNotFoundException;
import com.demo.empdept.model.ResultMessage;
import com.demo.empdept.service.IEmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/emp")
@Controller
public class EmpController {

    private Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private IEmpService empService;

    @PostMapping("/add")
    @ResponseBody
    public ResultMessage addEmp(@RequestBody Emp emp){
        ResultMessage msg = new ResultMessage();
        boolean bFlag = empService.createEmp(emp);
        if(bFlag){
            msg.setErrCode(100);
            msg.setErrMsg("success");
        }else{
            msg.setErrCode(-999);
            msg.setErrMsg("failed");
        }

        return msg;
    }

    @PostMapping("/update")
    @ResponseBody
    public ResultMessage modifyEmp(@RequestBody Emp emp){
        ResultMessage msg = new ResultMessage();

        boolean bFlag = false;
        try{
            bFlag = empService.modifyEmp(emp);
        }catch(EmpNotFoundException ex) {
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
            msg.setErrMsg("parameter illegal!");
        }

        return msg;
    }

    @GetMapping("/del/{empId}")
    @ResponseBody
    public ResultMessage delEmp(@PathVariable("empId") long empId){
        ResultMessage msg = new ResultMessage();

        boolean bFlag = false;
        try{
            bFlag = empService.deleteEmp(empId);
        }catch (EmpNotFoundException ex){
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

}
