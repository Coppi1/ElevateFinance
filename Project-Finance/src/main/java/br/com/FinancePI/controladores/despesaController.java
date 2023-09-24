package br.com.FinancePI.controladores;

import br.com.FinancePI.DAO.despesaDAO;
import br.com.FinancePI.Entidades.Despesa;
import br.com.FinancePI.Entidades.Receita;
import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean
@Component
@ViewScoped
@Data
public class despesaController {

    @Autowired
    despesaDAO despDAO = new despesaDAO();

    private Despesa despesa = new Despesa();

    private String valorBoolean;


    public void salvar(){

        valorBoolean = "true";

        despDAO.inserir(despesa);
        despesa = new Despesa();
        Messages.addFlashGlobalInfo("Registro salvo com sucesso");
    }

    public void excluir() {

        valorBoolean = "false";

        if (despesa.getCod() != null) {

            Despesa despesaParaExcluir = despDAO.buscarDespesaPorId(despesa.getCod());
            if (despesaParaExcluir != null) {
                despDAO.excluir(despesaParaExcluir);
                Messages.addFlashGlobalInfo("Registro excluído com sucesso");
            } else {
                Messages.addFlashGlobalError("Registro não encontrado");
            }
        } else {
            Messages.addFlashGlobalError("Número único da despesa não especificado");
        }

    }

    public void buscarDespesa() {

        valorBoolean = "false";

        if (despesa.getCod() != null) {
            Despesa despesaEncontrada = despDAO.buscarDespesaPorId(despesa.getCod());
            if (despesaEncontrada != null) {
                despesa = despesaEncontrada;
            } else {
                Messages.addFlashGlobalError("Registro não encontrado");
            }
        } else {
            Messages.addFlashGlobalError("Número único da despesa não especificado");
        }

    }

    public void alterarDespesa() {

        valorBoolean = "true";

        despDAO.alterar(despesa);
        Messages.addFlashGlobalInfo("Registro alterado com sucesso");

    }







}
