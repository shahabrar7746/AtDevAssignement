package com.api.AtDevAssignement_FileSystem.Response;

import com.api.AtDevAssignement_FileSystem.DTOs.StudentDTO;

import java.util.List;

public class Response {
    public int status;
    public String message="Successfull";
    public List<StudentDTO> data;

    public Response(int status,List<StudentDTO> data){
        this.data = data;
        this.status = status;
    }
}
