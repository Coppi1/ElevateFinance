package br.com.FinancePI.controladores;

import br.com.FinancePI.DAO.despesaDAO;
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
public class despesaController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    despesaDAO despDAO = new despesaDAO();

    @Inject
    private Despesa despesa;

    private String valorBoolean;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double soma;

    private List<Despesa> listaDespesas;


    public void salvar(){

        valorBoolean = "true";

        despDAO.inserir(despesa);
        despesa = new Despesa();
        Messages.addFlashGlobalInfo("Registro salvo com sucesso");
    }

    public void excluir() {

        valorBoolean = "false";

        if (despesa.getId() != null) {

            Despesa despesaParaExcluir = despDAO.buscarDespesaPorId(despesa.getId());
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

        if (despesa.getId() != null) {
            Despesa despesaEncontrada = despDAO.buscarDespesaPorId(despesa.getId());
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

    public void buscarListaDespesa() {
        if (dataInicio != null && dataFim != null) {
            listaDespesas = despDAO.buscarListaDespesa(dataInicio, dataFim);
            if (listaDespesas.isEmpty()) {
                Messages.addFlashGlobalError("Nenhuma despesa encontrada no intervalo de datas especificado");
            }
        } else {
            Messages.addFlashGlobalError("Intervalo de datas não especificado");
        }
    }

    public void calcularSoma() {
        soma = listaDespesas.stream().mapToDouble(Despesa::getValor).sum();
    }





}
