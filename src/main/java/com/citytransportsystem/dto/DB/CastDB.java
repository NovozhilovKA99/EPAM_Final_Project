package com.citytransportsystem.dto.DB;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Valid
public class CastDB {

    private Long id;

    @NotNull(message = "Водитель должен быть указан")
    private Long driverId;

    @NotNull(message = "Кондуктор должен быть указан")
    private Long conductorId;

    @NotNull(message = "Маршрут должен быть указан")
    private Long routeId;

    @NotNull(message = "Транспорт должен быть указан")
    private Long transportId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "Начало смены должно быть указано")
    @Future(message = "Начало смены должно быть позже текущего момента")
    private LocalDateTime startTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "Конец смены должен быть указан")
    @Future(message = "Конец смены должен быть позже текущего момента")
    private LocalDateTime endTime;

    public CastDB(){
    }

    public CastDB(Long id, Long driverId, Long conductorId,
                  Long routeId, Long transportId,
                  LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.driverId = driverId;
        this.conductorId = conductorId;
        this.routeId = routeId;
        this.transportId = transportId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public CastDB(Long driverId, Long conductorId,
                  Long routeId, Long transportId,
                  LocalDateTime startTime, LocalDateTime endTime) {
        this.driverId = driverId;
        this.conductorId = conductorId;
        this.routeId = routeId;
        this.transportId = transportId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getConductorId() {
        return conductorId;
    }

    public void setConductorId(Long conductorId) {
        this.conductorId = conductorId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastDB castDB = (CastDB) o;
        return id.equals(castDB.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
