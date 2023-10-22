package br.com.FinancePI.Controladores;

import br.com.helloworld.Entidades.Usuario;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.omnifaces.util.Messages;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@EqualsAndHashCode
@Component
@Data
@ViewScoped
public class UsuarioController implements Serializable {

    public static final long serialVersionUID = 1L;

    private Usuario cadastroUsuario = new Usuario();

    public void entrar() {
        Messages.addFlashGlobalInfo("Cadastro Realizado com Sucesso!");
    }


}
