package com.demo.empdept.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultMessage implements Serializable {
    private int errCode;
    private String errMsg;
}
