package com.citytransportsystem.services;

import com.citytransportsystem.dto.Stop;

import java.util.List;

public interface StopService {
    List<Stop> getStopsByRouteId(Long routeId);
}
