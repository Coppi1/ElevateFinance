package br.com.FinancePI.controladores;

import br.com.FinancePI.Entidades.Despesa;
import br.com.FinancePI.servicos.DespesaService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Component
@Data
@ViewScoped
@Named
public class tabDespesaController implements Serializable {


    public static final long serialVersionUID = 1L;

    @Autowired
    private DespesaService despservico;


    @Inject
    private Despesa despData;


    private LocalDate dataInicio;


    private LocalDate dataFim;


    private List<Despesa> listaDespData;


    public void buscarListaDespesa() {

            try {
                if (dataInicio != null && dataFim != null) {
                    listaDespData = despservico.buscarListaDespesa(dataInicio, dataFim);
                    if (listaDespData.isEmpty()) {
                        Messages.addFlashGlobalError("Nenhuma despesa encontrada no intervalo de datas especificado");
                    }
                } else {
                    Messages.addFlashGlobalError("Intervalo de datas não especificado");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Messages.addFlashGlobalError("Ocorreu um erro ao buscar as despesas: " + e.getMessage());
            }
        }

    private void atualizarListaDespesa() {

        listaDespData = despservico.buscarListaDespesa(dataInicio, dataFim);

    }
}