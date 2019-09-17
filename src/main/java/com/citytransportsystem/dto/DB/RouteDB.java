package com.citytransportsystem.dto.DB;

import java.util.Objects;

public class RouteDB {
    private Long id;
    private Long number;

    public RouteDB(Long id, Long number) {
        this.id = id;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDB routeDB = (RouteDB) o;
        return id.equals(routeDB.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                '}';
    }
}
