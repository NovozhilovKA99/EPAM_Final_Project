package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModelRepositoryImpl implements ModelRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Model> rowMapper = (rowStr, rowNum) -> new Model(
            rowStr.getLong("idModel"),
            rowStr.getString("description"),
            rowStr.getLong("Type_idType")
    );

    @Override
    public void create(Model model) {
        String sql = "insert into 'mydb'.'Model' ('idModel', 'description', 'Type_idType') values(?, ?, ?)";
        jdbcTemplate.update(sql, model.getIdModel(), model.getDescription(), model.getIdType());
    }

    @Override
    public Model get(Long idModel) {
        String sql = "select * from 'mydb'.'Model' where idModel = ?";
        List<Model> model = jdbcTemplate.query(sql, new Object[]{idModel}, rowMapper);
        if (model.isEmpty()) {
            return null;
        } else {
            return model.get(0);
        }
    }

    @Override
    public void update(Model model) {
        String sql = "update model from 'mydb'.'Model' set description = ? where idModel = ?";
        jdbcTemplate.update(sql, model.getDescription(), model.getIdType());
    }

    @Override
    public void delete(Long idModel) {
        String sql = "delete model from 'mydb'.'Model' where idModel = ?";
        jdbcTemplate.update(sql, idModel);
    }

}
