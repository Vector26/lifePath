package com.lifepath.lifepath.repository;

import com.lifepath.lifepath.models.ProgressModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ProgressRepository extends MongoRepository<ProgressModel, String> {
    List<ProgressModel> findByUserIdAndDate(String userId, Date date);
}

