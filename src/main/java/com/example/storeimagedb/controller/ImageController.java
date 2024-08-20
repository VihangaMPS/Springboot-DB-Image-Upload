package com.example.storeimagedb.controller;

import com.example.storeimagedb.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final StorageService storageService;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {

        String uploadImage = storageService.uploadImage(file);
        return ResponseEntity.ok().body(uploadImage);
    }


    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImages(@PathVariable String fileName) throws IOException {
        byte[] downloadImage = storageService.downloadImage(fileName);

        return ResponseEntity.ok().contentType(MediaType.valueOf("image/png")).body(downloadImage);
    }
}
