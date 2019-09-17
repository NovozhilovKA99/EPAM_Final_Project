package com.citytransportsystem.dto;

import java.util.Objects;

public class Transport {
    private Long id;
    private Long modelId;
    private String regPlate;
    private Position position;

    public Transport(Long id, Long modelId, String regPlate) {
        this.id = id;
        this.modelId = modelId;
        this.regPlate = regPlate;
        this.position = null;
    }

    public Long getId() {
        return id;
    }

    public Long getModelId() {
        return modelId;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return id.equals(transport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", modelId=" + modelId +
                ", regPlate='" + regPlate + '\'' +
                '}';
    }
}
