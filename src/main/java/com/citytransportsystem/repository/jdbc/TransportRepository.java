package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Transport;

public interface TransportRepository {
    int create(Transport transport);

    Transport get(Long idTransport);

    int update(Transport transport);

    int delete(Long idTransport);
}
