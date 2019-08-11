package com.citytransportsystem.dto;

import java.util.Objects;

public class Model {
    private Long idModel;
    private String description;
    private Long idType;

    public Model(Long idModel, String description, Long idType) {
        this.idModel = idModel;
        this.description = description;
        this.idType = idType;
    }

    public Long getIdModel() {
        return idModel;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdType() {
        return idType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return idModel.equals(model.idModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModel);
    }

    @Override
    public String toString() {
        return "Model{" +
                ", description='" + description + '\'' +
                ", idType=" + idType +
                '}';
    }
}
