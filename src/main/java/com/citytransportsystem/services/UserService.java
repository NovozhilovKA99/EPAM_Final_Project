package com.citytransportsystem.services;

import com.citytransportsystem.dto.User;

import java.util.List;

public interface UserService {
    User getById(Long idUser);

    void regUser(User user);

    User checkUser(Long idUser, String password);

    boolean checkPassword(User user, String password);
}
