package com.citytransportsystem.dto;

import java.util.Objects;

public class Transport {
    private Long id;
    private Long modelId;
    private String transportNumber;

    public Transport(Long id, Long modelId, String transportNumber) {
        this.id = id;
        this.modelId = modelId;
        this.transportNumber = transportNumber;
    }

    public Long getId() {
        return id;
    }

    public Long getModelId() {
        return modelId;
    }

    public String getTransportNumber() {
        return transportNumber;
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
                ", transportNumber='" + transportNumber + '\'' +
                '}';
    }
}
