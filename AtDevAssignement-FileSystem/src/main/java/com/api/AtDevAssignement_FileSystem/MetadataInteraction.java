package com.api.AtDevAssignement_FileSystem;

import java.io.*;
import java.util.Scanner;

public class MetadataInteraction {

    private String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\api\\AtDevAssignement_FileSystem\\db\\Student\\Metadata\\Student.txt";
    public int count() throws IOException {
        File f = new File(path);
        //count:num;
        Scanner sc = new Scanner(f);
        String data = sc.nextLine().split(":")[1];
        int count = Integer.parseInt(data);
        FileWriter fw = new FileWriter(path);
        fw.write("count:"+ ++count);
        fw.close();
        return count;

    }



}
