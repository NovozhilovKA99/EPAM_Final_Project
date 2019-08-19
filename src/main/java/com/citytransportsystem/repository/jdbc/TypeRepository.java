package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Type;

public interface TypeRepository {
    int create(Type type);

    Type get(Long idType);

    int update(Type type);

    int delete(Long idType);
}
