package br.com.FinancePI.Controladores;

import br.com.FinancePI.DAO.UsuarioDAO;
import br.com.FinancePI.Entidades.Usuario;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

@Component
@ViewScoped
@Data
public class LoginController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    private UsuarioDAO usuarioDAO;

    private String loginEmail;
    private String loginSenha;

    public String login() throws IOException {
        Usuario usuario = usuarioDAO.buscaPorEmail(loginEmail);
        if (usuario != null) {
            if (usuario.getSenha() == loginSenha) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().redirect("META-INF/resources/Lancamento/telaLancamentoDespesa.xhtml");
                Messages.addFlashGlobalInfo("Sucesso!");
                return "Lancamento/telaLancamentoDespesa.xhtml.xhtml?faces-redirect=true";

            } else {
                Messages.addFlashGlobalInfo("Senha incorreta");
                return "Senha incorreta";
            }
        } else {
            Messages.addFlashGlobalInfo("Email Inexistente");
            return "email incorreto";
        }
    }

}
