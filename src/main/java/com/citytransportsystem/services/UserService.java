package com.citytransportsystem.services;

import com.citytransportsystem.dto.User;

public interface UserService {
    User getById(Long idUser);

    void regUser(User user);

    boolean setUser(Long idUser, String password);

    boolean checkPassword(User user, String password);

    String hash(String password);

    boolean checkUnique(User user);
}
