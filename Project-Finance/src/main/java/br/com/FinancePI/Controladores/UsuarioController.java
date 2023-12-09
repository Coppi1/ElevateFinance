package br.com.FinancePI.Controladores;


import br.com.FinancePI.DAO.UsuarioDAO;
import br.com.FinancePI.Entidades.Usuario;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.omnifaces.util.Messages;
import org.omnifaces.util.Utils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@EqualsAndHashCode
@Component
@Data
@ViewScoped
public class UsuarioController implements Serializable {

    public static final long serialVersionUID = 1L;

    @Autowired
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Inject
    Usuario usuario;


    private Usuario usuarioEdicao = new Usuario();

    //Metodo para cadastrar um novo usuario

    public void cadastro() {

        usuarioDAO.inserirUsuario(usuario);
        usuario = new Usuario();
        Messages.addFlashGlobalInfo("Usuario cadastrado com sucesso");

    }

    public void salvar(){

        usuarioDAO.inserirUsuario(usuario);
        usuario = new Usuario();
        Messages.addFlashGlobalInfo("Registro salvo com sucesso");
    }


    //Metodo para fazer a exclusao de um usuario
    



    public void entrar(Usuario usuario) {


        if(usuario == null) {
            throw new RuntimeException("Usuario não cadastrado");
        }



    }

}
