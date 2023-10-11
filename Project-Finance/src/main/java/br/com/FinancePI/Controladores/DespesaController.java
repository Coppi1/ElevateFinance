package br.com.FinancePI.Controladores;

import br.com.FinancePI.DAO.CategoriaDespesaDAO;
import br.com.FinancePI.DAO.DespesaDAO;
import br.com.FinancePI.Entidades.CategoriaDespesa;
import br.com.FinancePI.Entidades.Despesa;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Component
@Data
@ViewScoped
public class DespesaController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    DespesaDAO despDAO = new DespesaDAO();

    @Autowired
    CategoriaDespesaDAO categDAO = new CategoriaDespesaDAO();

    @Inject
    private Despesa despesa;

    private String valorBoolean;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double soma;

    private List<Despesa> listaDespesas;

    private List<CategoriaDespesa> categoriaDespesas;




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
        calcularSoma();
    }

    public void calcularSoma() {
        soma = listaDespesas.stream().mapToDouble(Despesa::getValor).sum();
    }






}
