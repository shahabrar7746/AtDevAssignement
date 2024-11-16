package com.api.AtDevAssignement.Exceptions;

public class InvalidStudentId extends Exception {
    public String message;
    public InvalidStudentId(String message) {
        super(message);
        this.message = message;
    }
}
