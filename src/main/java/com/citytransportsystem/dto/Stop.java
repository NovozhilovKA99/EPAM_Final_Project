package com.citytransportsystem.dto;

import java.util.Objects;

public class Stop {
    private Long id;
    private String name;
    private Long routeId;
    private Long indexRoute;
    private Boolean end;

    public Stop(Long id, String name, Long routeId, Long indexRoute, Boolean end) {
        this.id = id;
        this.name = name;
        this.routeId = routeId;
        this.indexRoute = indexRoute;
        this.end = end;
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

    public Long getIndexRoute() {
        return indexRoute;
    }

    public Boolean isEnd() {
        return end;
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
