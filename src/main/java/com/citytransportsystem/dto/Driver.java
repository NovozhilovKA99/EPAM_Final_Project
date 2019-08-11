package com.citytransportsystem.dto;

import java.time.LocalDate;
import java.util.List;

public final class Driver extends User {
    private List types;

    public Driver(Long idUser, String fullName, LocalDate birthday, Long contractId, List types) {
        super(idUser, fullName, birthday, contractId);
        this.types = types;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "types=" + types +
                ", idUser=" + idUser +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                ", contractId=" + contractId +
                '}';
    }
}
