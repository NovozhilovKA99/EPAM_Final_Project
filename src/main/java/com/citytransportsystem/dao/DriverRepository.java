package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Driver;

public interface DriverRepository {
    int create(Driver driver);

    Driver get(Long idUser);

    int update(Driver driver);

    int delete(Driver idUser);
}
