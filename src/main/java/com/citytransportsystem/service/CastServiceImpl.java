package com.citytransportsystem.service;

import com.citytransportsystem.dto.Cast;
import com.citytransportsystem.dto.DB.CastDB;
import com.citytransportsystem.dto.Position;
import com.citytransportsystem.dto.Transport;
import com.citytransportsystem.dto.User;
import com.citytransportsystem.exception.RouteException;
import com.citytransportsystem.exception.TransportException;
import com.citytransportsystem.exception.UserException;
import com.citytransportsystem.repository.jdbc.CastRepository;
import com.citytransportsystem.repository.jdbc.StopRepository;
import com.citytransportsystem.repository.jdbc.TransportRepository;
import com.citytransportsystem.repository.jdbc.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

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
    public int insert(CastDB cast)  throws UserException, RouteException, TransportException {
        if(!userRepository.checkUserHasType(cast.getDriverId(), cast.getTransportId())){
            throw new UserException("Водитель не имеет права управлять транспортным средством такого типа");
        }
        if(!castRepository.checkFreeUser(cast.getDriverId(), cast.getStartTime(), cast.getEndTime())){
            throw new UserException("Водитель уже занят во время смены");
        }
        if(!castRepository.checkFreeUser(cast.getConductorId(), cast.getStartTime(), cast.getEndTime())){
            throw new UserException("Кондуктор уже занят во время смены");
        }
        if(!castRepository.checkFreeTransport(cast.getTransportId(), cast.getStartTime(), cast.getEndTime())){
            throw new UserException("Транспорт уже занят во время смены");
        }
        return castRepository.create(cast);
    }

    @Scheduled(fixedRate = 60000)
    public void checkStartedCasts(){
        positionService.moveCasts();
        List<CastDB> castDBList = castRepository.getJustStartedCasts(LocalDateTime.now());
        for(CastDB castDB : castDBList){
            positionService.addCast(castConverterImpl.convertToCast(castDB), castDB.getRouteId());
        }
        log.info("Casts added", castDBList);
    }
}
