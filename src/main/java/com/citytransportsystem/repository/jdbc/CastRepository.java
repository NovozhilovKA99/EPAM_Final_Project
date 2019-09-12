package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.CastDB;

public interface CastRepository {
    int create(CastDB castDB);

    CastDB get(Long idCast);

    int update(CastDB castDB);

    int delete(Long idCast);
}
