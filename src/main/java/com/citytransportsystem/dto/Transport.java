package com.citytransportsystem.dto;

import java.util.Objects;

public class Transport {
    private Long idTransport;
    private Long idModel;
    private String transportNumber;

    public Transport(Long idTransport, Long idModel, String transportNumber) {
        this.idTransport = idTransport;
        this.idModel = idModel;
        this.transportNumber = transportNumber;
    }

    public Long getIdTransport() {
        return idTransport;
    }

    public Long getIdModel() {
        return idModel;
    }

    public String getTransportNumber() {
        return transportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return idTransport.equals(transport.idTransport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransport);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "idTransport=" + idTransport +
                ", idModel=" + idModel +
                ", transportNumber='" + transportNumber + '\'' +
                '}';
    }
}
