package com.api.AtDevAssignement_FileSystem;

import com.api.AtDevAssignement_FileSystem.Entities.Student;
import com.api.AtDevAssignement_FileSystem.Repository.StudentRepo;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//import com.api.AtDevAssignement_FileSystem.
@Component
public class FileInterface implements StudentRepo {

    private MetadataInteraction meta = new MetadataInteraction();
    private String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\api\\AtDevAssignement_FileSystem\\db\\Student\\data";
    public List<Student> findAll() throws IOException {
      List<Student> response = new ArrayList<>();

      File f = new File(path);
      File[] files = f.listFiles();
      for(File curFile : files){
          Student std = new Student();
          Scanner sc = new Scanner(curFile);
          std.id = Integer.parseInt(sc.nextLine().split(":")[1]);
              std.name = sc.nextLine().split(":")[1];
          std.status = sc.nextLine().split(":")[1];
          std.lastName = sc.nextLine().split(":")[1];

          response.add(std);
sc.close();
      }
return response;

    }

    @Override
    public Optional<Student> findById(int id) throws FileNotFoundException {
        File f = new File(path+"\\"+String.valueOf(id)+".txt");
        if(!f.isFile()){
            return Optional.empty();
        }
        Student std = new Student();
        Scanner sc = new Scanner(f);
        std.id = Integer.parseInt(sc.nextLine().split(":")[1]);
        std.name = sc.nextLine().split(":")[1];
        std.status = sc.nextLine().split(":")[1];
        std.lastName = sc.nextLine().split(":")[1];
        sc.close();
       Optional<Student> response = Optional.of(std);
return response;
    }

    @Override
    public void save(Student std) throws IOException {

        String recordId = String.valueOf(meta.count());
        FileWriter fw = new FileWriter(path+"\\"+recordId+".txt");
        fw.write("id:"+recordId+"\n");
        fw.write("name:"+std.name+"\n");
        fw.write("status:"+std.status+"\n");
        fw.write("lastName:"+std.lastName+"\n");
        fw.close();

    }

    @Override
    public boolean deleteById(int id) throws IOException, InterruptedException {
      File f = new File(path+"\\"+String.valueOf(id)+".txt");
     return f.delete();
    }

    @Override
    public void update(int id, Student std) throws IOException {
        String recordId = String.valueOf(id);
        FileWriter fw = new FileWriter(path+"\\"+recordId+".txt");

        fw.write("id:"+recordId+"\n");
        fw.write("name:"+std.name+"\n");
        fw.write("status:"+std.status+"\n");
        fw.write("lastName:"+std.lastName+"\n");
        fw.close();


    }
}
