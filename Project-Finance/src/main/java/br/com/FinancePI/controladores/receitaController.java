package br.com.FinancePI.controladores;

import br.com.FinancePI.DAO.despesaDAO;
import br.com.FinancePI.DAO.receitaDAO;
import br.com.FinancePI.Entidades.Despesa;
import br.com.FinancePI.Entidades.Receita;
import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Component
@Data
@ViewScoped
public class receitaController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    receitaDAO recDAO = new receitaDAO();

    @Inject
    private Receita receita;

    private String valorBoolean;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double soma;

    private List<Receita> listaReceita;


    public void salvar(){

        valorBoolean = "true";

        recDAO.inserir(receita);
        receita = new Receita();
        Messages.addFlashGlobalInfo("Registro salvo com sucesso");
    }

    public void excluir() {

        valorBoolean = "false";

        if (receita.getId() != null) {

            Receita receitaParaExcluir = recDAO.buscarReceitaPorId(receita.getId());
            if (receitaParaExcluir != null) {
                recDAO.excluir(receitaParaExcluir);
                Messages.addFlashGlobalInfo("Registro excluído com sucesso");
            } else {
                Messages.addFlashGlobalError("Registro não encontrado");
            }
        } else {
            Messages.addFlashGlobalError("Número único da despesa não especificado");
        }

    }

    public void buscarReceita() {

        valorBoolean = "false";

        if (receita.getId() != null) {
            Receita receitaEncontrada = recDAO.buscarReceitaPorId(receita.getId());
            if (receitaEncontrada != null) {
                receita = receitaEncontrada;
            } else {
                Messages.addFlashGlobalError("Registro não encontrado");
            }
        } else {
            Messages.addFlashGlobalError("Número único da despesa não especificado");
        }

    }



    public void alterarReceita() {

        valorBoolean = "true";

        recDAO.alterar(receita);
        Messages.addFlashGlobalInfo("Registro alterado com sucesso");

    }

    public void buscarListaReceita() {
        if (dataInicio != null && dataFim != null) {
            listaReceita = recDAO.buscarListaReceita(dataInicio, dataFim);
            if (listaReceita.isEmpty()) {
                Messages.addFlashGlobalError("Nenhuma despesa encontrada no intervalo de datas especificado");
            }
        } else {
            Messages.addFlashGlobalError("Intervalo de datas não especificado");
        }
    }

    public void calcularSoma() {
        soma = listaReceita.stream().mapToDouble(Receita::getValorBruto).sum();
    }





}














