package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;


@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class ImageDownloadController {

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/image/{name}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("name") String filename) {

        try {
            Resource file = fileStorageService.loadAsResource(filename);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                    .body(file);
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No data");
        }
    }
}
