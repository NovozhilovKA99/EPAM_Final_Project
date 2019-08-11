package com.citytransportsystem.dto;

import java.util.Arrays;
import java.util.Objects;

public class Route {
    private Long idRoute;
    private Stop[]  stops;

    public Route(Long idRoute, Stop[] stops) {
        this.idRoute = idRoute;
        this.stops = stops;
    }

    public Long getIdRoute() {
        return idRoute;
    }

    public Stop[] getStops() {
        return stops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return idRoute.equals(route.idRoute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoute);
    }

    @Override
    public String toString() {
        return "Route{" +
                "idRoute=" + idRoute +
                ", stops=" + Arrays.toString(stops) +
                '}';
    }
}
