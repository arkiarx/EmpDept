package com.demo.empdept.exceptions;

public class EmpNotFoundException extends Exception{
    public EmpNotFoundException(){
        super("Employer Not Found!");
    }
}
