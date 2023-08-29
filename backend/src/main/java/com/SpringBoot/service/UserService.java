package com.SpringBoot.service;

import com.SpringBoot.entities.ServiceConsumer;
import com.SpringBoot.entities.User;

public interface UserService {
    User register(User user) throws Exception;

    User login(User user) throws Exception;

    User getUser(int id);
}
