package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.RouteDB;

import java.util.List;

public interface RouteRepository {
    int create(RouteDB routeDB);

    RouteDB get(Long idRoute);

    int update(RouteDB routeDB);

    int delete(Long idRoute);

    List<RouteDB> get();
}
