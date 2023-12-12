package com.lifepath.repository;

import com.lifepath.models.ProgressModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ProgressRepository extends MongoRepository<ProgressModel, String> {
    List<ProgressModel> findByUserIdAndDate(String userId, Date date);
}

