package br.com.FinancePI.Entidades;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class Login {

    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + login + " " + senha));
    }



}
