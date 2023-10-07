package br.com.FinancePI.controladores;

import br.com.FinancePI.DAO.despesaDAO;
import br.com.FinancePI.Entidades.Despesa;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Data;
import org.hibernate.service.spi.InjectService;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@ViewScoped
@Data
@Component
public class tabelaDespesaController implements Serializable {

    public static final long serialVersionUID = 1L;

    @Autowired
    despesaDAO listaDAO = new despesaDAO();

    private Despesa despesa = new Despesa();

    private String valorBoolean;
    private Date dataInicio;
    private Date dataFim;
    private List<Despesa> listaDespesas;

    public void buscarListaDespesa() {

        valorBoolean = "false";

        listaDespesas = listaDAO.buscarDespesasPorData(dataInicio, dataFim);
        if (dataInicio != null && dataFim != null) {
            if (listaDespesas.isEmpty()) {
                Messages.addFlashGlobalError("Nenhuma despesa encontrada no intervalo de datas especificado");
            }
        } else {
            Messages.addFlashGlobalError("Intervalo de datas não especificado");
        }

    }


    }
