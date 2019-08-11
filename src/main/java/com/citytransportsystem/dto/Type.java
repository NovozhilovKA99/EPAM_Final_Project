package com.citytransportsystem.dto;

import java.util.Objects;

public class Type {
    private Long idType;
    private String description;

    public Type(Long idType, String description) {
        this.idType = idType;
        this.description = description;
    }

    public Long getIdType() {
        return idType;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return idType.equals(type.idType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType);
    }

    @Override
    public String toString() {
        return "Type{" +
                "idType=" + idType +
                ", description='" + description + '\'' +
                '}';
    }


}
