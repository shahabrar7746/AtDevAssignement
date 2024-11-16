package com.api.AtDevAssignement_FileSystem.Service;

import com.api.AtDevAssignement_FileSystem.Exceptions.InvalidStudentId;
import com.api.AtDevAssignement_FileSystem.DTOs.StudentDTO;
import com.api.AtDevAssignement_FileSystem.Response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;


@Service
public interface StudentService {


    public ResponseEntity<Response> getAllStudents() throws IOException;

   public  ResponseEntity<StudentDTO> getStudent(int id) throws InvalidStudentId, FileNotFoundException;

    public ResponseEntity<StudentDTO> save(StudentDTO dto) throws IOException;

    ResponseEntity<StudentDTO> update(StudentDTO dto, int id) throws InvalidStudentId, IOException;

    ResponseEntity<String> delete(int id) throws InvalidStudentId, IOException, InterruptedException;
}
