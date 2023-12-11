package com.lifepath.lifepath.repository;


import com.lifepath.lifepath.models.ReflectionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReflectionRepository extends MongoRepository<ReflectionModel, String> {
    List<ReflectionModel> findByUserId(String userId);
}

