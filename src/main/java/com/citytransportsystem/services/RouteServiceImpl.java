package com.citytransportsystem.services;

import com.citytransportsystem.dto.DB.RouteDB;
import com.citytransportsystem.repository.jdbc.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public RouteDB getById(Long routeId) {
        return routeRepository.get(routeId);
    }

    @Override
    public List<RouteDB> getAllRoutes() {
        return routeRepository.get();
    }
}
