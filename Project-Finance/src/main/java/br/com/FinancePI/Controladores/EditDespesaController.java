package br.com.FinancePI.Controladores;

import br.com.FinancePI.DAO.DespesaDAO;
import br.com.FinancePI.Entidades.Despesa;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DialogFrameworkOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@EqualsAndHashCode
@Component
@Data
@RequestScoped
public class EditDespesaController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Inject
    private Despesa despesa;

    @Autowired
    DespesaDAO despDAO = new DespesaDAO();

    public EditDespesaController(Despesa despesa) {
        this.despesa = despesa;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void salvar() {
        // Validar os dados da despesa
        

        // Validar a descrição
        if (despesa.getDescricao() == null || despesa.getDescricao().trim().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A descrição é obrigatória.", ""));
            return;
        }

        // Validar o valor
        if (despesa.getValor() <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O valor deve ser maior que zero.", ""));
            return;
        }

        despDAO.inserir(despesa);

    }

    public void cancelar() {
        // Fechar a caixa de diálogo sem salvar as alterações
        PrimeFaces.current().dialog().closeDynamic(EditDespesaController.this);
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public void init() {
    }
}
