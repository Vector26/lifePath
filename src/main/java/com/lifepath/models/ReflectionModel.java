package com.lifepath.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Document
@Data
@NoArgsConstructor
public class ReflectionModel {

    @Id
    private String id;
    private String userId;
    private String content;
    private List<String> referencedReflectionIds;
}


