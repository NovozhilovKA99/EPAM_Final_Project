package com.citytransportsystem.dto;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String fullName;
    private LocalDate birthday;
    private String position;
    private Long contractId;
    private String password;

    public User(Long id, String login, String fullName, LocalDate birthday, String position, Long contractId, String password) {
        this.id = id;
        this.login = login;
        this.fullName = fullName;
        this.birthday = birthday;
        this.position = position;
        this.contractId = contractId;
        this.password = password;
    }

    public User(Long id, String login, String fullName, LocalDate birthday, Long contractId, String password) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.position = "User";
        this.contractId = contractId;
        this.password = password;
    }

    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                ", contractId=" + contractId +
                '}';
    }
}
