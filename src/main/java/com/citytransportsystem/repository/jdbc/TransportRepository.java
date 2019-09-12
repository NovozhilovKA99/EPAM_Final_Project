package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.TransportDB;

public interface TransportRepository {
    int create(TransportDB transportDB);

    TransportDB get(Long idTransport);

    int update(TransportDB transportDB);

    int delete(Long idTransport);
}
