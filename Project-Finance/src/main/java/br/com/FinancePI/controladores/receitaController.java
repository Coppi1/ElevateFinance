package br.com.FinancePI.controladores;

import br.com.FinancePI.DAO.receitaDAO;
import br.com.FinancePI.Entidades.Receita;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class receitaController {

    @Autowired
    private receitaDAO rDao;

    private Receita receita = new Receita();

    public void salvar(){

        rDao.inserir(receita);
    }


}





