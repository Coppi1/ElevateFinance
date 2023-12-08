package br.com.FinancePI.Controladores;

import br.com.FinancePI.Entidades.Usuario;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ViewScoped
@Data
public class LoginController implements Serializable {


    public static final long serialVersionUID = 1L;

    private String loginEmail;
    private String loginSenha;


    public String entrar(){

        if(validarEmailESenha()){
           return  "META-INF/resources/Lancamento/telaLancamentoDespesa.xhtml";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email ou senha incorretos"));
            return null;
        }
    }


    public boolean validarEmailESenha(){

        UsuarioController usuarioController = new UsuarioController();

        return true;
    }

}
