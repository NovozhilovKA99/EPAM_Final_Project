package com.citytransportsystem.services;

import com.citytransportsystem.dto.Cast;
import com.citytransportsystem.dto.DB.CastDB;
import com.citytransportsystem.dto.User;
import com.citytransportsystem.repository.jdbc.CastRepository;
import com.citytransportsystem.services.converters.CastConverterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CastServiceImpl implements CastService {

    @Autowired
    private CastConverterImpl castConverterImpl;

    @Autowired
    private CastRepository castRepository;

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
}
