package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Transport;
import org.springframework.stereotype.Repository;

@Repository
public class TransportRepositoryImpl implements TransportRepository {
    @Override
    public int create(Transport transport) {
        return 0;
    }

    @Override
    public Transport get(Long idTransport) {
        return null;
    }

    @Override
    public int update(Transport transport) {
        return 0;
    }

    @Override
    public int delete(Long idTransport) {
        return 0;
    }
}
