package com.lifepath.lifepath.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@NoArgsConstructor
public class ProgressModel {

    @Id
    private String id;

    private String userId;
    private Date date;
    private String status; // e.g., Completed, Failed

}
