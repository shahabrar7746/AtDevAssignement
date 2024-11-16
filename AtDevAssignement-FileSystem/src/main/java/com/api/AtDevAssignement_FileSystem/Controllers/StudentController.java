package com.api.AtDevAssignement_FileSystem.Controllers;


import com.api.AtDevAssignement_FileSystem.DTOs.StudentDTO;
import com.api.AtDevAssignement_FileSystem.Exceptions.InvalidStudentId;
import com.api.AtDevAssignement_FileSystem.Response.Response;
import com.api.AtDevAssignement_FileSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService service;


    @GetMapping("/student")
    public ResponseEntity<Response> getAllStudent() throws IOException {
        return service.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") int id) throws InvalidStudentId, FileNotFoundException {
        return service.getStudent(id);
    }

    @PostMapping("/save")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO dto) throws IOException {
        return service.save(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO dto,@PathVariable("id") int id) throws InvalidStudentId, IOException {
        return service.update(dto,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) throws InvalidStudentId, IOException, InterruptedException {
        return service.delete(id);
    }


}
