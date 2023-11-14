package br.com.FinancePI.Controladores;

import br.com.FinancePI.DAO.NaturezaDAO;
import br.com.FinancePI.DAO.ReceitaDAO;
import br.com.FinancePI.Entidades.Natureza;
import br.com.FinancePI.Entidades.Receita;
import jakarta.annotation.PostConstruct;
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
public class ReceitaController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    ReceitaDAO recDAO = new ReceitaDAO();

    @Autowired
    NaturezaDAO natDAO = new NaturezaDAO();


    @Inject
    private Receita receita;

    private String valorBoolean;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double soma;

    private List<Receita> listaReceitas;

    private List<Natureza> listaCategoriaReceitas;

    private Natureza categoriaReceita;



    @PostConstruct
    public void init() {
        listaCategoriaReceitas = natDAO.listarCategorias();
    }

    public void salvar() {

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
            Messages.addFlashGlobalError("Código de Lançamento da receita não encontrado");
        }

    }

    /*
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
*/


    public void alterarReceita() {

        valorBoolean = "true";

        recDAO.alterar(receita);
        Messages.addFlashGlobalInfo("Registro alterado com sucesso");

        receitaEdicao = new Receita();

        buscarListaReceita();
    }

    public void buscarListaReceita() {
        if (dataInicio != null && dataFim != null) {
            listaReceitas = recDAO.buscarListaReceita(dataInicio, dataFim);
            if (listaReceitas.isEmpty()) {
                Messages.addFlashGlobalError("Nenhuma despesa encontrada no intervalo de datas especificado");
            }
        } else {
            Messages.addFlashGlobalError("Intervalo de datas não especificado");
        }
        calcularSoma();
    }

    public void calcularSoma() {
        soma = listaReceitas.stream().mapToDouble(Receita::getValor).sum();
    }

    private Receita receitaEdicao = new Receita();

    public void viewProducts(Receita receitaSelecionada) {

        receitaEdicao = receitaSelecionada;

        // Abre a caixa de diálogo para editar a receita

        PrimeFaces.current().executeScript("PF('editReceitaDialog').show();");


    }

    public void cancelar() {
        // Fechar a caixa de diálogo sem salvar as alterações

        PrimeFaces.current().executeScript("PF('editReceitaDialog').hide();");
    }


}















