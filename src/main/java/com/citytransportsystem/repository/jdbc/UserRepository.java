package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.User;

public interface UserRepository {
    int create(User user);

    User get(Long idUser);

    int update(User user);

    int delete(Long idUser);
}
