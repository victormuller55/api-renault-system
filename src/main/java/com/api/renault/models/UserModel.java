package com.api.renault.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_renault_user")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer idRenaultUser;

    @JsonProperty("name")
    private String nomeUser;

    @JsonProperty("login")
    private String loginUser;

    @JsonProperty("password")
    private String passwordUser;

    public UserModel() {
        this.passwordUser = "123";
    }

    public Integer getIdRenaultUser() {
        return idRenaultUser;
    }

    public void setIdRenaultUser(Integer idRenaultUser) {
        this.idRenaultUser = idRenaultUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}