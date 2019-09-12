package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.ModelDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ModelRepositoryImpl implements ModelRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<ModelDB> rowMapper = (rowStr, rowNum) -> new ModelDB(
            rowStr.getLong("id"),
            rowStr.getString("description"),
            rowStr.getLong("Type_id")
    );

    @Override
    public int create(ModelDB modelDB) {
        String sql = "insert into 'ModelDB' ('id', 'description', 'Type_id') values(?, ?, ?)";
        return jdbcTemplate.update(sql,
                modelDB.getId(),
                modelDB.getDescription(),
                modelDB.getTypeId()
        );
    }

    @Override
    public ModelDB get(Long id) {
        String sql = "select * from 'ModelDB' where 'id' = ?";
        return jdbcTemplate.queryForObject(sql, ModelDB.class, id);
    }

    @Override
    public int update(ModelDB modelDB) {
        String sql = "update modelDB from 'ModelDB' set 'description' = ? where 'id' = ?";
        return jdbcTemplate.update(sql,
                modelDB.getDescription(),
                modelDB.getTypeId()
        );
    }

    @Override
    public int delete(Long id) {
        String sql = "delete model from 'ModelDB' where 'id' = ?";
        return jdbcTemplate.update(sql, id);
    }

}
