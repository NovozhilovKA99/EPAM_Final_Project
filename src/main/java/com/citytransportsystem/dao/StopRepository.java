package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Stop;

public interface StopRepository {
    void create(Stop stop);

    Stop get(Long idStop);

    void update(Stop stop);

    void delete(Long idStop);
}
