package com.demo.empdept.controller;

import com.demo.empdept.entity.Emp;
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

        boolean bFlag = empService.modifyEmp(emp);
        if(bFlag){
            msg.setErrCode(100);
            msg.setErrMsg("success");
        }else{
            msg.setErrCode(-999);
            msg.setErrMsg("failed");
        }

        return msg;
    }

    @GetMapping("/del/{empId}")
    @ResponseBody
    public ResultMessage delEmp(@PathVariable("empId") long empId){
        ResultMessage msg = new ResultMessage();

        boolean bFlag = empService.deleteEmp(empId);
        if(bFlag){
            msg.setErrCode(100);
            msg.setErrMsg("success");
        }else{
            msg.setErrCode(-999);
            msg.setErrMsg("failed");
        }

        return msg;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Emp> list(){
        return empService.listEmp();
    }
}
