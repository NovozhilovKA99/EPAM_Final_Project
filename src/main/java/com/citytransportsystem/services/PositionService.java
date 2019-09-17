package com.citytransportsystem.services;

import com.citytransportsystem.dto.Route;
import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.dto.Transport;

import java.util.Map;

public interface PositionService {

    Map<Stop, Transport> getOnRoute(Long routeId);

    Boolean addTransport(Transport transport, Long routeId);
}
