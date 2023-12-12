package com.lifepath.repository;


import com.lifepath.models.ReflectionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReflectionRepository extends MongoRepository<ReflectionModel, String> {
    List<ReflectionModel> findByUserId(String userId);
}

