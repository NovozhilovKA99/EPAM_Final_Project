package com.citytransportsystem.service.converters;

import com.citytransportsystem.dto.*;
import com.citytransportsystem.dto.DB.CastDB;
import com.citytransportsystem.dto.DB.RouteDB;
import com.citytransportsystem.repository.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CastConverterImpl {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private UserRepository userRepository;

    public Cast convertToCast(CastDB castDB){
        Transport transport = transportRepository.get(castDB.getTransportId());
        Model model = modelRepository.get(transport.getModelId());
        Type type = typeRepository.get(model.getTypeId());
        User conductor = userRepository.get(castDB.getConductorId());
        User driver = userRepository.get(castDB.getDriverId());
        RouteDB route = routeRepository.get(castDB.getRouteId());
        return new Cast(driver, conductor, route, transport, model, type, castDB.getStartTime(), castDB.getEndTime());
    }

}
