package com.citytransportsystem.service;

import com.citytransportsystem.dto.DB.RouteDB;

import java.util.List;

public interface RouteService {
    RouteDB getById(Long routeId);

    List<RouteDB> getAllRoutes();
}
