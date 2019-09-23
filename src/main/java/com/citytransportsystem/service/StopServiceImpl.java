package com.citytransportsystem.service;

import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.repository.jdbc.StopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StopServiceImpl implements StopService {

    @Autowired
    private StopRepository stopRepository;

    @Override
    public List<Stop> getStopsByRouteId(Long routeId) {
        return stopRepository.getByRouteId(routeId);
    }
}
