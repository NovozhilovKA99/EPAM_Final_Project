package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Stop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StopRepositoryImpl implements StopRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<Stop> rowMapper = (rowStr, rowNum) -> new Stop(
            rowStr.getLong("id"),
            rowStr.getString("name"),
            rowStr.getLong("route_Id"),
            rowStr.getLong("indexRoute"),
            rowStr.getBoolean("end")
    );

    @Override
    public int create(Stop stop){
        String sql = "insert into 'Stop' ('name', 'route_Id', 'indexRoute', 'end') VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,
                stop.getName(),
                stop.getRouteId(),
                stop.getIndexRoute(),
                stop.isEnd()
        );
    }

    @Override
    public Stop get(Long id){
        String sql = "select 'id', 'name', 'route_Id', 'direction' from 'Stop' where id = ?";
        return jdbcTemplate.queryForObject(sql, Stop.class, id);
    }

    @Override
    public int update(Stop stop){
        String sql = "update stop from 'Stop' set 'name' = ?, 'route_Id' = ?, 'indexRoute' = ?, 'end' = ? where id = ?";
        return jdbcTemplate.update(sql,
                stop.getName(),
                stop.getRouteId(),
                stop.getIndexRoute(),
                stop.isEnd(),
                stop.getId()
        );
    }

    @Override
    public int delete(Long id){
        String sql = "delete stop from 'stop' where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Stop> getByRouteId(Long routeId) {
        String sql = "select 'id', 'name', 'route_Id', 'indexRoute', 'end' " +
                "from 'Stop' where 'route_Id' = ? order by 'indexRoute' asc";
        return jdbcTemplate.query(sql, rowMapper, routeId);
    }
}
