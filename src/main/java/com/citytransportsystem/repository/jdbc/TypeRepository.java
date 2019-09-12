package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.TypeDB;

public interface TypeRepository {
    int create(TypeDB typeDB);

    TypeDB get(Long idType);

    int update(TypeDB typeDB);

    int delete(Long idType);
}
