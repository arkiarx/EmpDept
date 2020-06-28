package com.demo.empdept.service.impl;

import com.demo.empdept.entity.EmpDept;
import com.demo.empdept.model.QueryModel;
import com.demo.empdept.repository.IEmpDeptRepository;
import com.demo.empdept.service.IEmpDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service("empDeptService")
public class EmpDeptServiceImpl implements IEmpDeptService {

    private Logger logger = LoggerFactory.getLogger(EmpDeptServiceImpl.class);

    @Autowired
    private IEmpDeptRepository empDeptRepository;

    @Override
    public List<EmpDept> listEmpDeptPage(QueryModel qModel, int page) {
//        Pageable pageable = PageRequest.of(page, 10);
        Pageable pageable = PageRequest.of(page,10);

        Specification<EmpDept> spec = new Specification<EmpDept>() {
            @Override
            public Predicate toPredicate(Root<EmpDept> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();

                if(null != qModel.getEmpName() && !qModel.getEmpName().equals("")){
                    list.add(cb.equal(root.get("empName").as(String.class), qModel.getEmpName()));
                }

                if(qModel.getEmpId() > 0){
                    list.add(cb.equal(root.get("empId").as(Long.class), qModel.getEmpId()));
                }

                if(qModel.getAge() > 0){
                    list.add(cb.equal(root.get("age").as(Integer.class), qModel.getAge()));
                }

                if(null != qModel.getDeptName() && !qModel.getDeptName().equals("")){
                    list.add(cb.equal(root.get("deptName").as(String.class), qModel.getDeptName()));
                }

                Predicate[] p = new Predicate[list.size()];
                return query.where(list.toArray(p)).getRestriction();
//                return cb.and(list.toArray(p));
            }
        };

        Page<EmpDept> pageObjs = empDeptRepository.findAll(spec, pageable);

        List<EmpDept> pageList = pageObjs.getContent();

        logger.info("pageList size() : " + pageList.size());



        return pageList;
    }
}
