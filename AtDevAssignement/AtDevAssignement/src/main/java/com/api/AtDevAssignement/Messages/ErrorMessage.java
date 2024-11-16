package com.api.AtDevAssignement.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data

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
