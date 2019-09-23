package com.citytransportsystem.service;

import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.dto.Transport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class PositionServiceImpl implements PositionService {

    private Map<Long, Set<Transport>> transportOnRoute;

    public PositionServiceImpl() {
        this.transportOnRoute = new HashMap<Long, Set<Transport>>();
    }

    @Override
    public Map<Stop, Transport> getOnRoute(Long routeId) {
        return new HashMap<>();
    }

    @Override
    public Boolean addTransport(Transport transport, Long routeId) {
        if(transportOnRoute.get(routeId) != null){
            return transportOnRoute.get(routeId).add(transport);
        }
        else{
            transportOnRoute.put(routeId, new HashSet<Transport>(Arrays.asList(transport)));
            return true;
        }
    }
}
