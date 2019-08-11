package com.citytransportsystem.dto;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    protected Long idUser;
    protected String fullName;
    protected LocalDate birthday;
    protected String position;
    protected Long contractId;

    public User(Long idUser, String fullName, LocalDate birthday, String position, Long contractId) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.birthday = birthday;
        this.position = position;
        this.contractId = contractId;
    }

    public User(Long idUser, String fullName, LocalDate birthday, Long contractId) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.birthday = birthday;
        this.position = "User";
        this.contractId = contractId;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getContractId() {
        return contractId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser.equals(user.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                ", contractId=" + contractId +
                '}';
    }
}
