package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Type;

public interface TypeRepository {
    void create(Type type);

    Type get(Long idType);

    void update(Type type);

    void delete(Long idType);
}
