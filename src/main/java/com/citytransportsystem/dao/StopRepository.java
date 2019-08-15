package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Stop;

public interface StopRepository {
    int create(Stop stop);

    Stop get(Long idStop);

    int update(Stop stop);

    int delete(Long idStop);
}
