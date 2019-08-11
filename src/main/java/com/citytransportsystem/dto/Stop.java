package com.citytransportsystem.dto;

import java.util.Objects;

public class Stop {
    private Long idStop;
    private String name;
    private Long idRoute;
    private String position;

    public Stop(Long idStop, String name, Long idRoute, String position) {
        this.idStop = idStop;
        this.name = name;
        this.idRoute = idRoute;
        this.position = position;
    }

    public Long getIdStop() {
        return idStop;
    }

    public String getName() {
        return name;
    }

    public Long getIdRoute() {
        return idRoute;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return idStop.equals(stop.idStop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStop);
    }

    @Override
    public String toString() {
        return "Stop{" +
                ", name='" + name + '\'' +
                ", idRoute=" + idRoute +
                ", position='" + position + '\'' +
                '}';
    }
}
