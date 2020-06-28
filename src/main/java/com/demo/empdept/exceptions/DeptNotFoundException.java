package com.demo.empdept.exceptions;

public class DeptNotFoundException extends Exception{
    public DeptNotFoundException(){
        super("Department Not Found!");
    }
}
