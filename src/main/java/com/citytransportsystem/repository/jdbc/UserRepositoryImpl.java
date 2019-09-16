package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> rowMapper = (rowStr, rowNum) -> new User(
            rowStr.getLong("id"),
            rowStr.getString("login"),
            rowStr.getString("fullName"),
            rowStr.getDate("birthday").toLocalDate(),
            rowStr.getString("position"),
            rowStr.getLong("contractId"),
            rowStr.getString("password")
    );

    @Override
    public int create(User user) {
        String sql = "insert into 'user' ('fullName', 'birthday', " +
                "'position, 'contractId', 'login', 'password') " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                user.getFullName(),
                user.getBirthday(),
                user.getPosition(),
                user.getContractId(),
                user.getLogin(),
                user.getPassword()
        );
    }

    @Override
    public User get(Long id){
        String sql = "Select 'id', 'fullName', 'birthday', 'position, 'contractId', 'login', 'password' from 'user' where id = ?";
        return jdbcTemplate.queryForObject(sql, User.class, id);
    }

    @Override
    public int update(User user){
        String sql = "update user from 'user' set " +
                "'fullName' = ?, 'birthday' = ?, 'position' = ?, " +
                "'contractId' = ?, login = ?, password = ? " +
                "where 'id' = ?";
        return jdbcTemplate.update(sql,
                user.getFullName(),
                user.getBirthday(),
                user.getPosition(),
                user.getContractId(),
                user.getLogin(),
                user.getPassword(),
                user.getId()
        );
    }

    @Override
    public int delete(Long id){
        String sql = "delete user from 'user' where 'id' = ?";
        return jdbcTemplate.update(sql, id);
    }
}
