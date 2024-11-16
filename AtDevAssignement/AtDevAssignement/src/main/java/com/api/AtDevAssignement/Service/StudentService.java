package com.api.AtDevAssignement.Service;

import com.api.AtDevAssignement.DTOs.StudentDTO;
import com.api.AtDevAssignement.Exceptions.InvalidStudentId;
import com.api.AtDevAssignement.Response.Response;
import org.springframework.http.ResponseEntity;

public interface StudentService {


    public ResponseEntity<Response> getAllStudents();

   public  ResponseEntity<StudentDTO> getStudent(int id) throws InvalidStudentId;

    public ResponseEntity<StudentDTO> save(StudentDTO dto);

    ResponseEntity<StudentDTO> update(StudentDTO dto, int id) throws InvalidStudentId;

    ResponseEntity<String> delete(int id) throws InvalidStudentId;
}
