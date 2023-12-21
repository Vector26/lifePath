package com.lifepath.models;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "user_profiles")
@Data
@NoArgsConstructor
public class ProfileModel {
    @Id
    private String id;

    @Field(name = "user_id")
    private Long userId; // Reference to UserModel ID

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date dateOfBirth;

    public static String genId(){
        Ulid ulid = UlidCreator.getMonotonicUlid();
        return ulid.toString();
    }
}
