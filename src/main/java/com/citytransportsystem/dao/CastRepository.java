package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Cast;

public interface CastRepository {
    int create(Cast cast);

    Cast get(Long idCast);

    int update(Cast cast);

    int delete(Long idCast);
}
