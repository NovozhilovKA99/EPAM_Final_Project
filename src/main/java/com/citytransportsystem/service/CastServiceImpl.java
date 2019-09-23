package com.citytransportsystem.service;

import com.citytransportsystem.dto.Cast;
import com.citytransportsystem.dto.DB.CastDB;
import com.citytransportsystem.dto.Position;
import com.citytransportsystem.dto.Transport;
import com.citytransportsystem.dto.User;
import com.citytransportsystem.repository.jdbc.CastRepository;
import com.citytransportsystem.repository.jdbc.StopRepository;
import com.citytransportsystem.repository.jdbc.TransportRepository;
import com.citytransportsystem.service.converters.CastConverterImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CastServiceImpl implements CastService {

    @Autowired
    private PositionService positionService;

    @Autowired
    private CastConverterImpl castConverterImpl;

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private StopRepository stopRepository;

    @Override
    public CastDB getCastById(Long castId) {
        return castRepository.get(castId);
    }

    @Override
    public List<Cast> getCastByUser(User user) {;
        return castRepository.getCastByUserId(user.getId()).stream()
                .map(castConverterImpl::convertToCast)
                .collect(Collectors.toList());
    }

    @Override
    public int insert(CastDB cast) {
        return castRepository.create(cast);
    }

    @Scheduled(fixedRate = 60000)
    public void checkStartedCasts(){
        List<CastDB> castDBList = castRepository.getStartedCasts(LocalDateTime.now());
        for(CastDB castDB : castDBList){
            Transport transport = transportRepository.get(castDB.getTransportId());
            transport.setPosition(new Position(stopRepository.getFirstStopForRoute(castDB.getRouteId())));
            positionService.addTransport(transport, castDB.getRouteId());
        }
    }
}
