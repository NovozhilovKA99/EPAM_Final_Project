package com.citytransportsystem.dto;

import java.util.List;

public class Route {
    private Long id;
    private List<Stop> stops;

    public Route(Long id, List<Stop> stops) {
        this.id = id;
        this.stops = stops;
    }

    public Long getId() {
        return id;
    }

    public List<Stop> getStops() {
        return stops;
    }
}
