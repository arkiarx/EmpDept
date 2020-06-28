package com.demo.empdept.exceptions;

public class DeptExistedException extends Exception{
    public DeptExistedException(){
        super("Department Already Existed!");
    }
}
