package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Type;
import com.citytransportsystem.dto.User;

public interface UserRepository {
    void create(User user);

    User get(Long idUser);

    Type getUserType(Long idUser);

    void update(User user);

    void delete(Long idUser);
}
