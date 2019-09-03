package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Autowired
    private DateTimeFormatter dateTimeFormatter;

    private RowMapper<User> rowMapper = (rowStr, rowNum) -> new User(
            rowStr.getLong("id"),
            rowStr.getString("fullName"),
            LocalDate.parse(rowStr.getString("birthday"), dateTimeFormatter),
            rowStr.getString("position"),
            rowStr.getLong("contractId")
    );

    @Override
    public int create(User user) {
        String sql = "insert into 'mydb'.'user' ('id', 'fullName', 'birthday', 'position, 'contractId') VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getId(), user.getFullName(), user.getBirthday(), user.getPosition(), user.getContractId());
    }

    @Override
    public User get(Long id){
        String sql = "Select 'id', 'fullName', 'birthday', 'position, 'contractId' from 'mydb'.'user' where id = ?";
        return jdbcTemplate.queryForObject(sql, User.class, id);
    }

    @Override
    public int update(User user){
        String sql = "update user from 'mydb'.'user' set 'fullName' = ?, 'birthday' = ?, 'position' = ?, 'contractId' = ? where 'id' = ?";
        return jdbcTemplate.update(sql, user.getFullName(), user.getBirthday(), user.getPosition(), user.getContractId(), user.getId());
    }

    public int delete(Long id){
        String sql = "delete user from 'mydb'.'user' where 'id' = ?";
        return jdbcTemplate.update(sql, id);
    }
}
