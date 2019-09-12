package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.TypeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TypeRepositoryImpl implements TypeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<TypeDB> rowMapper = (rowStr, rowNum) -> new TypeDB(
            rowStr.getLong("id"),
            rowStr.getString("description")
    );

    @Override
    public int create(TypeDB typeDB) {
        String sql = "insert into 'TypeDB' ('id', 'description') VALUES (?, ?)";
        return jdbcTemplate.update(sql,
                typeDB.getId(),
                typeDB.getDescription()
        );
    }

    @Override
    public TypeDB get(Long id) {
        String sql = "select 'id', 'description' 'TypeDB' where 'id' = ?";
        return jdbcTemplate.queryForObject(sql, TypeDB.class, id);
    }

    @Override
    public int update(TypeDB typeDB) {
        String sql = "update typeDB from 'TypeDB' set 'description' = ? where 'id' = ?";
        return jdbcTemplate.update(sql,
                typeDB.getDescription(),
                typeDB.getId()
        );
    }

    @Override
    public int delete(Long id) {
        String sql = "delete type from 'TypeDB' where 'id' = ?";
        return jdbcTemplate.update(sql, id);
    }
}
