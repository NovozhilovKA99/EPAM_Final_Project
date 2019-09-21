package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.DB.CastDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CastRepositoryImpl implements CastRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<CastDB> rowMapper = (rowStr, rowNum) -> new CastDB(
            rowStr.getLong("id"),
            rowStr.getLong("User_idDriver"),
            rowStr.getLong("User_idConductor"),
            rowStr.getLong("Route_id"),
            rowStr.getLong("Transport_id"),
            rowStr.getTimestamp("startTime").toLocalDateTime(),
            rowStr.getTimestamp("endTime").toLocalDateTime()
    );

    @Override
    public int create(CastDB castDB) {
        String sql = "insert into `Cast` " +
                "(`User_idDriver`, `User_idConductor`, `Route_id`, `Transport_id`, `startTime`, `endTime`) " +
                " where values(?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                castDB.getDriverId(),
                castDB.getConductorId(),
                castDB.getRouteId(),
                castDB.getTransportId(),
                Timestamp.valueOf(castDB.getStartTime()),
                Timestamp.valueOf(castDB.getEndTime())
        );
    }

    @Override
    public CastDB get(Long idCast) {
        String sql = "select `id`, `User_idDriver`, `User_idConductor`, `Route_id`, " +
                "`Transport_id`, `startTime`, `endTime`" +
                "from `Cast` where `id` = ?";
        return jdbcTemplate.queryForObject(sql, CastDB.class, idCast);
    }

    @Override
    public List<CastDB> getCastByUserId(Long userId) {
        String sql = "select `id`, `User_idDriver`, `User_idConductor`, `Route_id`, " +
                "`Transport_id`, `startTime`, `endTime`  from `Cast` where User_idDriver = ? or User_idConductor = ?";
        return jdbcTemplate.query(sql, rowMapper, userId, userId);
    }

    @Override
    public int update(CastDB castDB) {
        String sql = "update cast from `Cast` where `id` = ? set " +
                "`User_idDriver` = ? `User_idConductor` = ? " +
                "`Route_id` = ? `Transport_id` = ? `startTime` = ? `endTime` = ?";
        return jdbcTemplate.update(sql,
                castDB.getId(),
                castDB.getDriverId(),
                castDB.getConductorId(),
                castDB.getRouteId(),
                castDB.getTransportId(),
                Timestamp.valueOf(castDB.getStartTime()),
                Timestamp.valueOf(castDB.getEndTime())
        );
    }

    @Override
    public int delete(Long idCast) {
        String sql = "delete cast from `Cast` where `id` = ?";
        return jdbcTemplate.update(sql, idCast);
    }

    @Override
    public List<CastDB> getStartedCasts(LocalDateTime now) {
        return null;
    }
}
