package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Stop;

import java.util.List;

public interface StopRepository {
    int create(Stop stop);

    Stop get(Long idStop);

    int update(Stop stop);

    int delete(Long idStop);

    List<Stop> getByRouteId(Long routeId);

    Stop getFirstStopForRoute(Long routeId);
}
