package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Driver;

public interface DriverRepository {
    void create(Driver driver);

    Driver get(Long idUser);

    void update(Driver driver);

    void delete(Driver idUser);
}
