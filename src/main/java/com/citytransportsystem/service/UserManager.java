package com.citytransportsystem.service;

import com.citytransportsystem.dto.User;

public interface UserManager {

    User getUser();

    void setUser(User user);

    Boolean authorised();
}