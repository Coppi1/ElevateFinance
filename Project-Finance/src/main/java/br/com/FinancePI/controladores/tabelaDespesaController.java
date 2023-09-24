package br.com.FinancePI.controladores;

import br.com.FinancePI.DAO.despesaDAO;
import br.com.FinancePI.Entidades.Despesa;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@ViewScoped
@Data
@Component
public class tabelaDespesaController {

        @Autowired
        private despesaDAO despesaDAO;

        private List<Despesa> listaDespesas;

        public List<Despesa> getListaDespesas() {
            if (listaDespesas == null) {
                listaDespesas = despesaDAO.buscarTodasDespesas(); // Método para buscar as despesas do banco
            }
            return listaDespesas;
        }

    }
