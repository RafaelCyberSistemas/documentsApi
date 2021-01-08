package com.accenture.documentsApi.domain.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "tipo_user")
    private String tipoUser;

    public User() {
    }

    public User(int idUser) {
        this.idUser = idUser;
    }

    public User(String login, String password, String tipoUser) {
        this.login = login;
        this.password = password;
        this.tipoUser = tipoUser;
    }

    public User(int idUser, String login, String password, String tipoUser) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.tipoUser = tipoUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
}
