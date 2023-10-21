package br.com.FinancePI.Entidades;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@Data
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;
    private String senha;





}
