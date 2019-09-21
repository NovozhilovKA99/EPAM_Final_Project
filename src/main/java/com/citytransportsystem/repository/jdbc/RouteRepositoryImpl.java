package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.RouteDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<RouteDB> rowMapper = (rowStr, rowNum) -> new RouteDB(
            rowStr.getLong("id"),
            rowStr.getLong("number")
    );

    @Override
    public int create(RouteDB routeDB) {
        return 0;
    }

    @Override
    public RouteDB get(Long idRoute) {
        return null;
    }

    @Override
    public int update(RouteDB routeDB) {
        return 0;
    }

    @Override
    public int delete(Long idRoute) {
        return 0;
    }

    @Override
    public List<RouteDB> get() {
        String sql = "Select `id`, `number` from `Route`";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
