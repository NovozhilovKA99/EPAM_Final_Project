package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.UserDB;
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

//    @Autowired
    private DateTimeFormatter dateTimeFormatter;

    private RowMapper<UserDB> rowMapper = (rowStr, rowNum) -> new UserDB(
            rowStr.getLong("id"),
            rowStr.getString("fullName"),
            LocalDate.parse(rowStr.getString("birthday"), dateTimeFormatter),
            rowStr.getString("position"),
            rowStr.getLong("contractId")
    );

    @Override
    public int create(UserDB userDB) {
        String sql = "insert into 'userDB' ('id', 'fullName', 'birthday', 'position, 'contractId') " +
                "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                userDB.getId(),
                userDB.getFullName(),
                userDB.getBirthday(),
                userDB.getPosition(),
                userDB.getContractId()
        );
    }

    @Override
    public UserDB get(Long id){
        String sql = "Select 'id', 'fullName', 'birthday', 'position, 'contractId' from 'user' where id = ?";
        return jdbcTemplate.queryForObject(sql, UserDB.class, id);
    }

    @Override
    public int update(UserDB userDB){
        String sql = "update userDB from 'userDB' set 'fullName' = ?, 'birthday' = ?, 'position' = ?, 'contractId' = ? " +
                "where 'id' = ?";
        return jdbcTemplate.update(sql,
                userDB.getFullName(),
                userDB.getBirthday(),
                userDB.getPosition(),
                userDB.getContractId(),
                userDB.getId());
    }

    @Override
    public int delete(Long id){
        String sql = "delete user from 'user' where 'id' = ?";
        return jdbcTemplate.update(sql, id);
    }
}
