package com.codecool.dogshelter.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class FileStorageService {

    private final String fileStorageLocation = "upload/";

    /* todo write config file for setting upload directory
    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
    }*/

    public String storeFile(MultipartFile file) {

        String originalFilename = file.getOriginalFilename();

        try {
            File convertFile = new File(fileStorageLocation + originalFilename);
            int counter = 0;
            while (convertFile.exists()) {
                String filename = generateNewName(originalFilename, ++counter);
                convertFile = new File(fileStorageLocation + filename);
            }
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();

            return convertFile.getName();
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + originalFilename + ". Please try again!", ex);
        }
    }

    private String generateNewName(String originalFilename, int counter) {

        String[] fileNameSplit = originalFilename.split("\\.");
        fileNameSplit[fileNameSplit.length - 2] += "_" + counter + ".";
        StringBuilder sb = new StringBuilder();
        Arrays.stream(fileNameSplit).forEach(sb::append);
        return sb.toString();

    }

    public Resource loadAsResource(String filename) throws IOException {
        try {
            Path filePath = Paths.get(fileStorageLocation, filename);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new FileNotFoundException(
                        "Could not read file: " + filename);
            }
        }
        catch (MalformedURLException e) {
            throw new IOException("Could not read file: " + filename, e);
        }
    }
}
