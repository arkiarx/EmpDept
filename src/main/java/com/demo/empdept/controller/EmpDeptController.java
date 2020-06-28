package com.demo.empdept.controller;

import com.demo.empdept.entity.EmpDept;
import com.demo.empdept.model.QueryModel;
import com.demo.empdept.model.ResultList;
import com.demo.empdept.service.IEmpDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/empdept")
@Controller
public class EmpDeptController {

    private Logger logger = LoggerFactory.getLogger(EmpDeptController.class);

    @Autowired
    private IEmpDeptService empDeptService;

    /**
     * QUERY EMPDEPT
     * @param qModel QUERY MODEL
     * @param page STARTS WITH 0
     * @return
     */
    @GetMapping("/list/{page}")
    @ResponseBody
    public ResultList<EmpDept> queryPagedList(@RequestBody QueryModel qModel,
                                              @PathVariable("page") int page){
        //
        logger.info("empName : " + qModel.getEmpName());
        logger.info("empId : " + qModel.getEmpId() );
        logger.info("age : " + qModel.getAge());
        logger.info("deptName : " + qModel.getDeptName());

        ResultList<EmpDept> resultList = new ResultList<>();

        List<EmpDept> list = empDeptService.listEmpDeptPage(qModel, page);

        resultList.setErrCode(100);
        resultList.setErrMsg("success");
        resultList.setResultList(list);

        return resultList;
    }
}
