package com.demo.empdept.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="view_empdept")
public class EmpDept implements Serializable {

    @Id
    @Column(name="emp_id")
    private Long empId;

    @Column(name="emp_name")
    private String empName;

    @Column(name="dept_name")
    private String deptName;

    @Column(name="gender")
    private String gender;

    @Column(name="mobile")
    private String mobile;

    @Column(name="address")
    private String address;

    @Column(name="age")
    private Integer age;

    @Column(name="create_time")
    private Timestamp createTime;

    @Column(name="update_time")
    private Timestamp updateTime;
}
