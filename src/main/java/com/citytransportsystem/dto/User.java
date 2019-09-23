package com.citytransportsystem.dto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Valid
public class User {
    private Long id;
    @NotNull
    @Size(min = 3, message = "Длина логина больше 3 символов")
    private String login;
    private String fullName;
    private LocalDate birthday;
    private String position;
    private Long contractId;
    @NotNull
    @Size(min = 6)
    private String password;

    public User(){
        this.id = null;
        this.login = null;
        this.fullName = null;
        this.birthday = null;
        this.position = null;
        this.contractId = null;
        this.password = null;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
