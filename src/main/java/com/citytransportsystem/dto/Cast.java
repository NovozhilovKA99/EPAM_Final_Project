package com.citytransportsystem.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cast {
    private Long idCast;
    private User driver;
    private User conductor;
    private Route route;
    private Transport transport;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Cast(Long idCast, User driver, User conductor, Route route, Transport transport, LocalDateTime startTime, LocalDateTime endTime) {
        this.idCast = idCast;
        this.driver = driver;
        this.conductor = conductor;
        this.route = route;
        this.transport = transport;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getIdCast() {
        return idCast;
    }

    public User getDriver() {
        return driver;
    }

    public User getConductor() {
        return conductor;
    }

    public Route getRoute() {
        return route;
    }

    public Transport getTransport() {
        return transport;
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
        return idCast.equals(cast.idCast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCast);
    }

    @Override
    public String toString() {
        return "Cast{" +
                "idCast=" + idCast +
                ", driver=" + driver +
                ", conductor=" + conductor +
                ", route=" + route +
                ", transport=" + transport +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }


}
