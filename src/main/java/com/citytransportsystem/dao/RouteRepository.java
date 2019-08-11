package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Route;

public interface RouteRepository {
    void create(Route route);

    Route get(Long idRoute);

    void update(Route route);

    void delete(Long idRoute);
}
