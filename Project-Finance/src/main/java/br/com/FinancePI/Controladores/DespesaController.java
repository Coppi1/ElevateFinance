package br.com.FinancePI.Controladores;

import br.com.FinancePI.DAO.NaturezaDAO;
import br.com.FinancePI.DAO.DespesaDAO;
import br.com.FinancePI.Entidades.Natureza;
import br.com.FinancePI.Entidades.Despesa;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode
@Component
@Data
@ViewScoped
public class DespesaController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    DespesaDAO despDAO = new DespesaDAO();

    @Autowired
    NaturezaDAO natDAO = new NaturezaDAO();


    private Despesa despesa;

    private String valorBoolean;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double soma;

    private List<Despesa> listaDespesas;

    private List<Natureza> listaNaturezas;

    private Natureza natureza;

    private Despesa despesaEdicao = new Despesa();

    @PostConstruct
    public void init() {
        listaNaturezas = natDAO.listarCategorias();

        dataInicio = LocalDate.now();
        dataFim = LocalDate.now();
    }



    public void salvar() {

        valorBoolean = "true";
        despesa.setNatureza(natureza);
        despDAO.inserir(despesa);
        despesa = new Despesa();
        Messages.addFlashGlobalInfo("Registro salvo com sucesso");
    }


    public void excluirDespesa(Despesa despesaSelecionada) {

     despDAO.excluir(despesaSelecionada);

     listaDespesas = despDAO.buscarListaDespesa(dataInicio, dataFim);


    }

    // public void buscarDespesaPorID() {

    //  valorBoolean = "false";

    //   if (despesa.getId() != null) {
    //       Despesa despesaEncontrada = despDAO.buscarDespesaPorId(despesa.getId());
    //     if (despesaEncontrada != null) {
    //            despesa = despesaEncontrada;
    //      } else {
    //           Messages.addFlashGlobalError("Registro não encontrado");
    //       }
    //   } else {
    //     Messages.addFlashGlobalError("Número único da despesa não especificado");
    //    }

    //  }


    public void alterarDespesa() {

        valorBoolean = "true";

        despDAO.alterar(despesaEdicao);

        buscarListaDespesa();

        Messages.addFlashGlobalInfo("Registro alterado com sucesso");

        despesaEdicao = new Despesa();



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



    public void verDespesa(Despesa despesaSelecionada) {

        despesaEdicao = despesaSelecionada;

        // Abrir a caixa de diálogo para editar a despesa
        PrimeFaces.current().executeScript("PF('editDespesaDialog').show();");


    }







}
