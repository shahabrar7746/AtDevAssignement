package com.api.AtDevAssignement.Controllers;


import com.api.AtDevAssignement.DTOs.StudentDTO;
import com.api.AtDevAssignement.Exceptions.InvalidStudentId;
import com.api.AtDevAssignement.Response.Response;
import com.api.AtDevAssignement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService service;


    @GetMapping("/student")
    public ResponseEntity<Response> getAllStudent(){
        return service.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") int id) throws InvalidStudentId {
        return service.getStudent(id);
    }

    @PostMapping("/save")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO dto){
        return service.save(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO dto,@PathVariable("id") int id) throws InvalidStudentId {
        return service.update(dto,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) throws InvalidStudentId {
        return service.delete(id);
    }


}
