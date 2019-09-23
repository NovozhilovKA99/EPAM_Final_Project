package com.citytransportsystem.service;

import com.citytransportsystem.dto.Cast;
import com.citytransportsystem.dto.DB.CastDB;
import com.citytransportsystem.dto.User;

import java.util.List;

public interface CastService {
    CastDB getCastById(Long castId);

    List<Cast> getCastByUser(User user);

    int insert(CastDB cast);
}
