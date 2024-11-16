package com.api.AtDevAssignement_FileSystem.Repository;


import com.api.AtDevAssignement_FileSystem.Entities.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface StudentRepo  {
    List<Student> findAll() throws IOException;

    Optional<Student> findById(int id) throws FileNotFoundException;

void save(Student std) throws IOException;

boolean deleteById(int id) throws IOException, InterruptedException;

void update(int id, Student std) throws IOException;

}
