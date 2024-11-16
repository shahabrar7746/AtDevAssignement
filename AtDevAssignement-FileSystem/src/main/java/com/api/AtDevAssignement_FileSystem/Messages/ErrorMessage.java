package com.api.AtDevAssignement_FileSystem.Messages;

;
import org.springframework.http.HttpStatus;


public class ErrorMessage {

    public ErrorMessage(){

    }
    public String message;
    public HttpStatus status;
    public ErrorMessage(String message,HttpStatus status){
        this.message = message;
        this.status = status;
    }
}
