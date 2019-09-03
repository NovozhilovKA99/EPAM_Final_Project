package com.citytransportsystem.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cast {
    private Long id;
    private Long driverId;
    private Long conductorId;
    private Long routeId;
    private Long transportId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Cast(Long id, Long driverId, Long conductorId, Long routeId, Long transportId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
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
        Cast cast = (Cast) o;
        return id.equals(cast.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
