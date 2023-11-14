package br.com.FinancePI.Controladores;

import br.com.FinancePI.DAO.ParceiroDAO;
import br.com.FinancePI.Entidades.Parceiro;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@ViewScoped
public class ParceiroController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    ParceiroDAO parceiroDAO = new ParceiroDAO();

    @Inject
    private Parceiro parceiro;

    private Parceiro parceiroBusca;


    public void salvar(){

        parceiroDAO.inserir(parceiro);
        parceiro = new Parceiro();
        Messages.addFlashGlobalInfo("Parceiro salvo com sucesso");

    }




}
