package com.citytransportsystem.services;

import com.citytransportsystem.dto.DB.UserDB;

public interface UserService {
    UserDB getById(Long idUser);

    void regUser(UserDB userDB);

    UserDB checkUser(Long idUser, String password);

    boolean checkPassword(UserDB userDB, String password);
}
