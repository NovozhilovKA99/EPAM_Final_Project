package com.citytransportsystem.service;

import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.dto.Transport;

import java.util.Map;
import java.util.Set;

public interface PositionService {

    Map<Long, Transport> getOnRoute(Long routeId);

    Boolean addTransport(Transport transport, Long routeId);
}
