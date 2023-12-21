package com.lifepath.repository;

import com.lifepath.models.ProfileModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<ProfileModel, String> {
}

