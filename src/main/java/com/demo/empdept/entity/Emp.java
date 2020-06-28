package com.demo.empdept.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name="tbl_emp")
public class Emp implements Serializable {

    @Id
    @Column(name="emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(name="emp_name")
    private String empName;

    @Column(name="dept_id")
    private int deptId;

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
