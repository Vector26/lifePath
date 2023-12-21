package com.lifepath.events.listeners;

import com.lifepath.events.publishers.UserCreatedEvent;
import com.lifepath.models.ProfileModel;
import com.lifepath.models.UserModel;
import com.lifepath.repository.ProfileRepository;
import com.lifepath.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserProfileListener {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserRepository userRepository;

    @EventListener
    public void onUserCreated(UserCreatedEvent event) {
        UserModel user = event.getUser();
        ProfileModel profile = new ProfileModel();
        profile.setUserId(user.getId());
        profile.setId(profile.genId());
        user.setProfileId(profile.getId());
        if(profileRepository.save(profile)!=null)
            userRepository.save(user);
    }
}

