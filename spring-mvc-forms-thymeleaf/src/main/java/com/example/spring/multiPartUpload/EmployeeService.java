package com.example.spring.multiPartUpload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

/**
 * created by Atiye Mousavi
 * Date: 12/10/2021
 * Time: 6:11 PM
 **/

@Service
public class EmployeeService {
    public void save(Employee employee){
        saveFile(employee.getDocument());
    }
    private void saveFile(MultipartFile multipartFile){
        try {
            saveToFileSystem(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void saveToFileSystem(MultipartFile multipartFile) throws IOException {
        String dir= Files.createTempDirectory("tmpDir").toFile().getAbsolutePath();
        File file=new File(dir+File.pathSeparator + multipartFile.getName());
        try(OutputStream os=new FileOutputStream(file)){
            os.write(multipartFile.getBytes());
        }
    }
}
