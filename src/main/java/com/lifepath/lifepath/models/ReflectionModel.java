package com.lifepath.lifepath.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@Table(name = "reflections")
public class ReflectionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userId;
    private String content; // Text of the reflection/journal entry

    // Getters and setters
}

