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
            rowStr.getLong("idUser"),
            rowStr.getString("fullName"),
            LocalDate.parse(rowStr.getString("birthdate"), dateTimeFormatter),
            rowStr.getString("position"),
            rowStr.getLong("contractId")
    );

    @Override
    public int create(User user) {
        String sql = "insert into 'mydb'.'user' ('idUser', 'fullName', 'birthday', 'position, 'contractId') VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getIdUser(), user.getFullName(), user.getBirthday(), user.getPosition(), user.getContractId());
    }

    @Override
    public User get(Long idUser){
        String sql = "Select * from 'mydb'.'user' where idUser = ?";
        List<User> userList = jdbcTemplate.query(sql, new Object[]{idUser}, rowMapper);
        if (userList.isEmpty()){
            return null;
        }
        else{
            return userList.get(0);
        }
    }

    @Override
    public int update(User user){
        String sql = "update user from 'mydb'.'user' set fullName = ?, birthday = ?, position = ?, contractId = ? where idUser = ?";
        return jdbcTemplate.update(sql, user.getFullName(), user.getBirthday(), user.getPosition(), user.getContractId(), user.getIdUser());
    }

    public int delete(Long idUser){
        String sql = "delete user from 'mydb'.'user' where idUser = ?";
        return jdbcTemplate.update(sql, idUser);
    }
}
