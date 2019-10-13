package com.citytransportsystem.service;

import com.citytransportsystem.dto.Cast;
import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.dto.Transport;

import java.util.Map;
import java.util.Set;

public interface PositionService {

    Map<Long, Cast> getOnRoute(Long routeId);

    Boolean addCast(Cast cast, Long routeId);

    void moveCasts();
}
