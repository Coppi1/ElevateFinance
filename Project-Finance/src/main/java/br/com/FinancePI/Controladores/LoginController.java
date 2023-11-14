package br.com.FinancePI.Controladores;

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


    public void entrar(){
        Messages.addFlashGlobalInfo("Login efetuado com sucesso!");
    }


}
