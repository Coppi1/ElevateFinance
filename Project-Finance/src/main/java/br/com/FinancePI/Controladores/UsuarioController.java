package br.com.FinancePI.Controladores;


import br.com.FinancePI.DAO.UsuarioDAO;
import br.com.FinancePI.Entidades.Usuario;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.omnifaces.util.Messages;
import org.omnifaces.util.Utils;
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

    //Metodo para fazer a exclusao de um usuario
    public void excluir() {

        if (usuario.getId() != null) {

            Usuario exclusaoUsuario = usuarioDAO.buscarUsuarioId(usuario.getId());
            if (exclusaoUsuario != null) {
                usuarioDAO.excluirUsuario(exclusaoUsuario);
                Messages.addFlashGlobalInfo("Cadastro de usuario excluido com sucesso");
            } else {
                Messages.addFlashGlobalInfo("Cadastro de usuario nao encontrado");
            }

        } else {
            Messages.addFlashGlobalInfo("Codigo de usuario nao encontrado");
        }
    }

    //Metodo para alterar o registro do usuario
    public void alterar() {

        usuarioDAO.alterarUsuario(usuario);
        Messages.addFlashGlobalInfo("Cadastro de usuario alterado com sucesso");
        usuarioEdicao = new Usuario();

    }

    public void buscarUsuario() {

        if (usuario.getId() != null) {

            Usuario usuarioLocalizado = usuarioDAO.buscarUsuarioId(usuario.getId());
            if (usuarioLocalizado != null) {
                usuarioDAO.buscarUsuarioId(usuarioLocalizado.getId());
                Messages.addFlashGlobalInfo("Cadastro de usuario localizado com sucesso");
            }
        } else {
            Messages.addFlashGlobalInfo("Cadastro de usuario nao lolizado");
        }
    }
}
