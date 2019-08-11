package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Transport;

public interface TransportRepository {
    void create(Transport transport);

    Transport get(Long idTransport);

    void update(Transport transport);

    void delete(Long idTransport);
}
