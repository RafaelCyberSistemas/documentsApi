package com.accenture.documentsApi.dto;

public class UserDto {

    private String login;
    private String password;
    private String tipoUser;

    public UserDto() {
    }

    public UserDto(String login, String password, String tipoUser) {
        this.login = login;
        this.password = password;
        this.tipoUser = tipoUser;
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
