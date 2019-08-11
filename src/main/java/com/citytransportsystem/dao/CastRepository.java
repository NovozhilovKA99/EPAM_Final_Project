package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Cast;

public interface CastRepository {
    void create(Cast cast);

    Cast get(Long idCast);

    void update(Cast cast);

    void delete(Long idCast);
}
