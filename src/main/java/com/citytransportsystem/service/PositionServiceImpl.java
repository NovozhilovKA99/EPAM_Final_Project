package com.citytransportsystem.service;

import com.citytransportsystem.dto.Cast;
import com.citytransportsystem.dto.DB.RouteDB;
import com.citytransportsystem.dto.Position;
import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.dto.Transport;
import com.citytransportsystem.repository.jdbc.RouteRepository;
import com.citytransportsystem.repository.jdbc.StopRepository;
import com.sun.java.accessibility.util.Translator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PositionServiceImpl implements PositionService {

    private Map<Long, Set<Cast>> castOnRoute;

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private RouteRepository routeRepository;

    public PositionServiceImpl() {
        this.castOnRoute = new HashMap<Long, Set<Cast>>();
    }

    @PostConstruct
    private void setRoutes(){
        for (RouteDB routeDB : routeRepository.get()){
            castOnRoute.put(routeDB.getId(), new HashSet<Cast>());
        }
    }

    @Override
    public Map<Long, Cast> getOnRoute(Long routeId) {
        if (castOnRoute.get(routeId) == null){
            return new HashMap<>();
        }
        return castOnRoute.get(routeId).stream()
                .collect(
                        Collectors
                                .toMap(
                                        (Cast cast) ->
                                            cast.getTransport().getPosition().getStop().getId()
                                        ,
                                        (Cast cast) -> cast,
                                        (cast,cast1) -> {
                                            return cast;
                                        }
                                        )
                        );
    }

    @Override
    public Boolean addCast(Cast cast, Long routeId) {
        cast.getTransport().setPosition(new Position(stopRepository.getFirstStopForRoute(
                cast.getRouteDB().getId()
        )));
        return castOnRoute.get(cast.getRouteDB().getId()).add(cast);
    }

    @Override
    public void moveCasts(){
        for (Set<Cast> castSet : castOnRoute.values()){
            for (Cast cast : castSet){
                castSet.removeIf(current -> current.getEndTime().isAfter(LocalDateTime.now()));
                Position position = cast.getTransport().getPosition();
                Stop stop = position.getStop();
                try {
                    position.setStop(stopRepository.getNextStop(stop));
                }
                catch (Exception exc){
                    position.setStop(stopRepository.getFirstStopForRoute(stop.getRouteId()));
                }
            }
        }
        log.info("Casts moved");
    }

}
