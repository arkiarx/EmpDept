package com.demo.empdept.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultList<T> extends ResultMessage implements Serializable {
    private List<T> resultList;
}
