package com.citytransportsystem.service;

import com.citytransportsystem.dto.Cast;
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

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PositionServiceImpl implements PositionService {

    private Map<Long, Set<Cast>> castOnRoute;

    @Autowired
    private StopRepository stopRepository;

    public PositionServiceImpl() {
        this.castOnRoute = new HashMap<Long, Set<Cast>>();
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
                                        (Cast cast) -> cast.getTransport().getPosition().getStop().getId(),
                                        cast -> cast));
    }

    @Override
    public Boolean addCast(Cast cast, Long routeId) {
        if(castOnRoute.get(routeId) != null){
            return castOnRoute.get(routeId).add(cast);
        }
        else{
            castOnRoute.put(routeId, new HashSet<Cast>(Collections.singletonList(cast)));
            return true;
        }
    }

    @Scheduled(fixedRate = 60000)
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
    }

}
