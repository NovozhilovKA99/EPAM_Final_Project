package com.citytransportsystem.dto;

import java.util.Objects;

public class Stop {
    private Long id;
    private String name;
    private Long routeId;

    public Stop(Long id, String name, Long routeId) {
        this.id = id;
        this.name = name;
        this.routeId = routeId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getRouteId() {
        return routeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return id.equals(stop.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Stop{" +
                ", name='" + name + '\'' +
                ", routeId=" + routeId +
                '}';
    }
}
