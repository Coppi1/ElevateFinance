package br.com.FinancePI.controladores;

import br.com.FinancePI.DAO.despesaDAO;
import br.com.FinancePI.Entidades.Despesa;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class despesaController {

    @Autowired
    despesaDAO despDAO = new despesaDAO();

    private Despesa despesa = new Despesa();
    public void salvar(){
       despDAO.inserir(despesa);
    }


}
