package com.api.AtDevAssignement_FileSystem.ServiceImplementation;


import com.api.AtDevAssignement_FileSystem.DTOs.StudentDTO;
import com.api.AtDevAssignement_FileSystem.Entities.Student;
import com.api.AtDevAssignement_FileSystem.Exceptions.InvalidStudentId;
import com.api.AtDevAssignement_FileSystem.FileInterface;
import com.api.AtDevAssignement_FileSystem.Repository.StudentRepo;
import com.api.AtDevAssignement_FileSystem.Response.Response;
import com.api.AtDevAssignement_FileSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

@Autowired
    private StudentRepo repo;

    @Override
    public ResponseEntity<Response> getAllStudents() throws IOException {
      List<Student> list = repo.findAll();
List<StudentDTO> students = new ArrayList<>();
for(int i =0;i<list.size();i++){
    Student std = list.get(i);
    StudentDTO dto = new StudentDTO();
    dto.status = std.status;
    dto.lastName = std.lastName;
    dto.name = std.name;
    students.add(dto);
}
        Response data = new Response(HttpStatus.ACCEPTED.value(), students);
return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<StudentDTO> getStudent(int id) throws InvalidStudentId, FileNotFoundException {
        Optional<Student> optionalObj = repo.findById(id);
        if(!optionalObj.isPresent()){
            throw new InvalidStudentId("Invalid Student id");
        }
        Student std = optionalObj.get();
        StudentDTO dto = new StudentDTO();
        dto.name = std.name;
        dto.status = std.status;
        dto.lastName = std.lastName;
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<StudentDTO> save(StudentDTO dto) throws IOException {
       Student std = new Student();
       std.name = dto.name;
       std.lastName = dto.lastName;
       std.status = dto.status;
       repo.save(std);
       return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<StudentDTO> update(StudentDTO dto, int id) throws InvalidStudentId, IOException {
        Optional<Student> optionalObj = repo.findById(id);
        if(!optionalObj.isPresent()){
            throw new InvalidStudentId("Invalid Student id");
        }
        Student std = optionalObj.get();
        std.status = dto.status;
        std.name = dto.name;
        std.lastName = dto.lastName;
        repo.update(id,std);
        return ResponseEntity.ok(dto);

    }

    @Override
    public ResponseEntity<String> delete(int id) throws InvalidStudentId, IOException, InterruptedException {
        Optional<Student> optionalObj = repo.findById(id);
        if(!optionalObj.isPresent()){
            throw new InvalidStudentId("Invalid Student id");
        }
        Student std = optionalObj.get();
        boolean isDeleted = repo.deleteById(id);
        return isDeleted ? ResponseEntity.ok("Deleted!!") : ResponseEntity.badRequest().body("Record not deleted");
    }
}
