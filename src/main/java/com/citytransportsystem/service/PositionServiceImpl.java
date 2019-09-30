package com.citytransportsystem.service;

import com.citytransportsystem.dto.Transport;
import com.sun.java.accessibility.util.Translator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PositionServiceImpl implements PositionService {

    private Map<Long, Set<Transport>> transportOnRoute;

    public PositionServiceImpl() {
        this.transportOnRoute = new HashMap<Long, Set<Transport>>();
    }

    @Override
    public Map<Long, Transport> getOnRoute(Long routeId) {
        return transportOnRoute.get(routeId).stream()
                .collect(
                        Collectors
                                .toMap(
                                        (Transport transport) -> transport.getPosition().getStop().getId(),
                                        transport -> transport));
    }

    @Override
    public Boolean addTransport(Transport transport, Long routeId) {
        if(transportOnRoute.get(routeId) != null){
            return transportOnRoute.get(routeId).add(transport);
        }
        else{
            transportOnRoute.put(routeId, new HashSet<Transport>(Collections.singletonList(transport)));
            return true;
        }
    }
}
