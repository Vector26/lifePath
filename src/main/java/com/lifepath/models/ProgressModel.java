package com.lifepath.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
public class ProgressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userId;
    private Date date;
    private String status; // e.g., Completed, Failed

}
