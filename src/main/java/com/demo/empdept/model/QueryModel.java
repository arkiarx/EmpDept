package com.demo.empdept.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryModel {

    private String empName;

    private Long empId;

    private int age;

    private String deptName;
}
