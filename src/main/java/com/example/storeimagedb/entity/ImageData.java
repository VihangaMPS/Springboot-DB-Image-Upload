package com.example.storeimagedb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ImageData")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob // Use only if i want to store data in binary format
    @Column(length = 500)
    private byte[] imageData;
}
