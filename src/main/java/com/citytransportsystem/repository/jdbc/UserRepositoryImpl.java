package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Slf4j
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

    private RowMapper<Long> longRowMapper = (rowStr, rowNum) -> rowStr.getLong("type_id");

    @Override
    public int create(User user) {
        String sql = "insert into `user` (`fullName`, `birthday`, `position`, `contractId`, `login`, `password`) VALUES (?, ?, ?, ?, ?, ?)";
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
        String sql = "Select `id`, `fullName`, `birthday`, `position`, " +
                "`contractId`, `login`, `password` from `user` where id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public User get(String login){
        String sql = "Select `id`, `fullName`, `birthday`, `position`, " +
                "`contractId`, `login`, `password` from `user` where login = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{login}, rowMapper);
    }

    @Override
    public Boolean checkUserHasType(Long userId, Long transportId){
        String sql = "Select type_id from `Driver_Has_Type` where user_id = ? and type_id in" +
                "(Select type_id from model inner join transport on model.id = transport.model_id where " +
                "transport.id = ?)";
        return !jdbcTemplate.query(sql, longRowMapper, userId, transportId).isEmpty();
    }

    @Override
    public int update(User user){
        String sql = "update user from `user` set " +
                "`fullName` = ?, `birthday` = ?, `position` = ?, " +
                "`contractId` = ?, `login` = ?, `password` = ? " +
                "where `id` = ?";
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
        String sql = "delete user from `user` where `id` = ?";
        return jdbcTemplate.update(sql, id);
    }
}
