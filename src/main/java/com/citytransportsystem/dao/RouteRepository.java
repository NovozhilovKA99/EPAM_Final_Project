package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Route;

public interface RouteRepository {
    int create(Route route);

    Route get(Long idRoute);

    int update(Route route);

    int delete(Long idRoute);
}
