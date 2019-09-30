package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Transport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TransportRepositoryImpl implements TransportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Transport> rowMapper = (rowStr, rowNum) -> new Transport(
            rowStr.getLong("id"),
            rowStr.getLong("model_id"),
            rowStr.getString("regPlate")
    );



    @Override
    public int create(Transport transport) {
        String sql = "insert tran in `transport` (`Model_id`, `regPlate`) values(?,?)";
        return jdbcTemplate.update(sql, transport.getModelId(), transport.getRegPlate());
    }

    @Override
    public Transport get(Long idTransport) {
        String sql = "select `id`, `model_id`, `regPlate` from `transport` where `id` = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper);
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
