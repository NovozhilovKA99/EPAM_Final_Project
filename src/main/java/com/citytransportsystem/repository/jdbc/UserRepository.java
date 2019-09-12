package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.UserDB;

public interface UserRepository {
    int create(UserDB userDB);

    UserDB get(Long idUser);

    int update(UserDB userDB);

    int delete(Long idUser);
}
