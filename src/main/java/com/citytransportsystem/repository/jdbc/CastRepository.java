package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.CastDB;
import com.citytransportsystem.dto.User;

import java.time.LocalDateTime;
import java.util.List;

public interface CastRepository {
    int create(CastDB castDB);

    CastDB get(Long idCast);

    List<CastDB> getCastByUserId(Long userId);

    int update(CastDB castDB);

    int delete(Long idCast);

    List<CastDB> getStartedCasts(LocalDateTime now);
}
