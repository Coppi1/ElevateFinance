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
public class tabDespesaController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    despesaDAO despDAO = new despesaDAO();

    @Inject
    private Despesa despesa;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Despesa> listaDespesas;

    public void buscarListaDespesa() {

        final long serialVersionUID = 1L;

        if (dataInicio != null && dataFim != null) {
            listaDespesas = despDAO.buscarListaDespesa(dataInicio, dataFim);
            if (listaDespesas.isEmpty()) {
                Messages.addFlashGlobalError("Nenhuma despesa encontrada no intervalo de datas especificado");
            }
        } else {
            Messages.addFlashGlobalError("Intervalo de datas não especificado");
        }
    }

}