package com.api.AtDevAssignement_FileSystem.ExceptionHandlers;


import com.api.AtDevAssignement_FileSystem.Exceptions.InvalidStudentId;
import com.api.AtDevAssignement_FileSystem.Messages.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus
@ControllerAdvice

public class InvalidStudentIdExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidStudentId.class)
    public ResponseEntity<ErrorMessage> handle(InvalidStudentId exception){
ErrorMessage message = new ErrorMessage(exception.message, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
}
