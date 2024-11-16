package com.api.AtDevAssignement_FileSystem.Exceptions;

public class InvalidStudentId extends Exception {
    public String message;
    public InvalidStudentId(String message) {
        super(message);
        this.message = message;
    }
}
