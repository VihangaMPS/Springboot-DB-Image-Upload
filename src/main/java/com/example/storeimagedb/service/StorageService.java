package com.example.storeimagedb.service;

import com.example.storeimagedb.entity.ImageData;
import com.example.storeimagedb.repository.StorageRepository;
import com.example.storeimagedb.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        return "file uploaded successfully : " + file.getOriginalFilename();
    }

    public byte[] downloadImage(String imageName) throws IOException {
        Optional<ImageData> dbImageData = storageRepository.findByName(imageName);

        byte[] image = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return image;

    }
}
