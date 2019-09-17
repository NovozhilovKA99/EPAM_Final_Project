package com.citytransportsystem.dto;

import com.citytransportsystem.dto.DB.RouteDB;

import java.time.LocalDateTime;

public class Cast {
    private User driver;
    private User conductor;
    private RouteDB routeDB;
    private Transport transport;
    private Model model;
    private Type type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Cast(User driver, User conductor, RouteDB routeDB,
                Transport transport, Model model, Type type,
                LocalDateTime startTime, LocalDateTime endTime) {
        this.driver = driver;
        this.conductor = conductor;
        this.routeDB = routeDB;
        this.transport = transport;
        this.model = model;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public User getConductor() {
        return conductor;
    }

    public void setConductor(User conductor) {
        this.conductor = conductor;
    }

    public RouteDB getRouteDB() {
        return routeDB;
    }

    public void setRouteDB(RouteDB routeDB) {
        this.routeDB = routeDB;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
