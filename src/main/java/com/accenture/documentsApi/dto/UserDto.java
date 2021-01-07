package com.accenture.documentsApi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UserDto {

    @NotBlank(message = "O login não poder ser vazio")
    private String login;
    @NotBlank(message = "A senha não pode ser vazia")
    private String password;
    @NotBlank(message = "Precisa informar o tipo do usuário")
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
