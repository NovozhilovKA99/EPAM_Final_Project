package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Slf4j
@Repository
public class ModelRepositoryImpl implements ModelRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Model> rowMapper = (rowStr, rowNum) -> new Model(
            rowStr.getLong("id"),
            rowStr.getString("description"),
            rowStr.getLong("Type_id")
    );

    @Override
    public int create(Model model) {
        String sql = "insert into `Model` (`description`, `Type_id`) values(?, ?)";
        return jdbcTemplate.update(sql,
                model.getDescription(),
                model.getTypeId()
        );
    }

    @Override
    public Model get(Long id) {
        String sql = "select `id`, `description`, `Type_id` from `Model` where `id` = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public int update(Model model) {
        String sql = "update model from `Model` set `description` = ? where `id` = ?";
        return jdbcTemplate.update(sql,
                model.getDescription(),
                model.getTypeId()
        );
    }

    @Override
    public int delete(Long id) {
        String sql = "delete model from `Model` where `id` = ?";
        return jdbcTemplate.update(sql, id);
    }

}
