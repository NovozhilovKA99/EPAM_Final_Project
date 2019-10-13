package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TypeRepositoryImpl implements TypeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Type> rowMapper = (rowStr, rowNum) -> new Type(
            rowStr.getLong("id"),
            rowStr.getString("description")
    );

    @Override
    public int create(Type type) {
        String sql = "insert into `Type` (`description`) VALUES (?, ?)";
        return jdbcTemplate.update(sql,
                type.getDescription()
        );
    }

    @Override
    public Type get(Long id) {
        String sql = "select `id`, `description` from `Type`  where `id` = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public int update(Type type) {
        String sql = "update type from `Type` set `description` = ? where `id` = ?";
        return jdbcTemplate.update(sql,
                type.getDescription(),
                type.getId()
        );
    }

    @Override
    public int delete(Long id) {
        String sql = "delete type from `Type` where `id` = ?";
        return jdbcTemplate.update(sql, id);
    }
}
