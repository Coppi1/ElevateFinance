package br.com.FinancePI.Controladores;

import br.com.FinancePI.DAO.LoginDAO;
import br.com.FinancePI.Entidades.Despesa;
import br.com.FinancePI.Entidades.Login;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@EqualsAndHashCode
@Component
@Data
@ViewScoped
public class LoginController  implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    LoginDAO loginDAO = new LoginDAO();

    @Inject
    private Login login;



    public void login() {
     //   FacesContext.getCurrentInstance().addMessage(null,
        //        new FacesMessage("Welcome " + login.setSenha(Login.); + " " + login.setSenha();));
    }

    public void logout(){

    }
}
