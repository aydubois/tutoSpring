package org.tutoSpring.ponyo.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id){
        super("Couldn't find employee "+id);
    }
}
