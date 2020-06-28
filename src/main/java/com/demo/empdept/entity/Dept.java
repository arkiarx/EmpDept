package com.demo.empdept.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name="tbl_dept")
public class Dept implements Serializable {

    @Id
    @Column(name="dept_id")
    private Integer deptId;

    @Column(name="dept_name")
    private String deptName;

    public Dept(int deptId, String deptName){
        this.deptId = deptId;
        this.deptName = deptName;
    }
}
