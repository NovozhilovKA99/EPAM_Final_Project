package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.StopDB;

import java.util.List;

public interface StopRepository {
    int create(StopDB stopDB);

    StopDB get(Long idStop);

    int update(StopDB stopDB);

    int delete(Long idStop);

    List<StopDB> getByRouteId(Long routeId);
}
