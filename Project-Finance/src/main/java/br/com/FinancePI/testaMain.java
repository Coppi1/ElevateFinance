package br.com.FinancePI;

import br.com.FinancePI.Entidades.Despesa;
import br.com.FinancePI.controladores.despesaController;
import br.com.FinancePI.controladores.tabDespesaController;

import java.time.LocalDate;

public class testaMain {

    public static void main(String[] args) {

        Despesa d = new Despesa();

        tabDespesaController controller = new tabDespesaController();

        controller.setDataInicio(LocalDate.of(2023, 10, 1));
        controller.setDataFim(LocalDate.of(2023, 10, 30));


        controller.buscarListaDespesa();

        for (Despesa despesa : controller.getListaDespData()) {
            System.out.println(controller.getDespData());
        }
    }

}
