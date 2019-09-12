package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.RouteDB;

public interface RouteRepository {
    int create(RouteDB routeDB);

    RouteDB get(Long idRoute);

    int update(RouteDB routeDB);

    int delete(Long idRoute);
}
