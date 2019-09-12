package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.ModelDB;

public interface ModelRepository {
    int create(ModelDB modelDB);

    ModelDB get(Long idModel);

    int update(ModelDB modelDB);

    int delete(Long idModel);
}
