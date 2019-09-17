package com.citytransportsystem.dto;

import java.util.Objects;

public class Model {
    private Long id;
    private String description;
    private Long typeId;

    public Model(Long id, String description, Long typeId) {
        this.id = id;
        this.description = description;
        this.typeId = typeId;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Long getTypeId() {
        return typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id.equals(model.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Model{" +
                ", description='" + description + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
