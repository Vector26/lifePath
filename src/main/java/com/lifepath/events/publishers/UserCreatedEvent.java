package com.lifepath.events.publishers;

import com.lifepath.models.UserModel;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserCreatedEvent extends ApplicationEvent {
    private UserModel user;
    public UserCreatedEvent(Object source, UserModel user) {
        super(source);
        this.user = user;
    }
}

