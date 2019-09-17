package com.citytransportsystem.services;

import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.repository.jdbc.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopServiceImpl implements StopService {

    @Autowired
    private StopRepository stopRepository;

    @Override
    public List<Stop> getStopsByRouteId(Long routeId) {
        return stopRepository.getByRouteId(routeId);
    }
}
