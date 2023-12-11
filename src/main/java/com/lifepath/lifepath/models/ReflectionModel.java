package com.lifepath.lifepath.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class ReflectionModel {

    @Id
    private String id;

    private String userId;
    private String content; // Text of the reflection/journal entry

    // Getters and setters
}

