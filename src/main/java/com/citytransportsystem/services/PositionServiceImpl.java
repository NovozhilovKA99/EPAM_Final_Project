package com.citytransportsystem.services;

import com.citytransportsystem.dto.Route;
import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.dto.Transport;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PositionServiceImpl implements PositionService {

    Map<Long, List<Transport>> transportOnRoute;

    public PositionServiceImpl() {
        this.transportOnRoute = new HashMap<Long, List<Transport>>();
    }

    //TODO Multi value map
    @Override
    public Map<Stop, Transport> getOnRoute(Long routeId) {
        return transportOnRoute.get(routeId).stream().;
    }

    @Override
    public Boolean addTransport(Transport transport, Long routeId) {
        return transportOnRoute.get(routeId).add(transport);
    }
}
