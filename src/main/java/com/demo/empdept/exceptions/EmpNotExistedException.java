package com.demo.empdept.exceptions;

public class EmpNotExistedException extends Exception{
    public EmpNotExistedException(){
        super("Employer Is Not Existed!");
    }
}
