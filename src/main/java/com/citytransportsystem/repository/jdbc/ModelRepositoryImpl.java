package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ModelRepositoryImpl implements ModelRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Model> rowMapper = (rowStr, rowNum) -> new Model(
            rowStr.getLong("id"),
            rowStr.getString("description"),
            rowStr.getLong("Type_idType")
    );

    @Override
    public int create(Model model) {
        String sql = "insert into 'mydb'.'Model' ('id', 'description', 'Type_idType') values(?, ?, ?)";
        return jdbcTemplate.update(sql, model.getId(), model.getDescription(), model.getTypeId());
    }

    @Override
    public Model get(Long id) {
        String sql = "select * from 'mydb'.'Model' where 'id' = ?";
        return jdbcTemplate.queryForObject(sql, Model.class, id);
    }

    @Override
    public int update(Model model) {
        String sql = "update model from 'mydb'.'Model' set 'description' = ? where 'id' = ?";
        return jdbcTemplate.update(sql, model.getDescription(), model.getTypeId());
    }

    @Override
    public int delete(Long id) {
        String sql = "delete model from 'mydb'.'Model' where 'id' = ?";
        return jdbcTemplate.update(sql, id);
    }

}
