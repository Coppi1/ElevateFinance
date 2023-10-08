package br.com.FinancePI.servicos;

import br.com.FinancePI.DAO.despesaDAO;
import br.com.FinancePI.Entidades.Despesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class DespesaService {

    private final despesaDAO despDAO;

    @Autowired
    public DespesaService(despesaDAO despDAO) {
        this.despDAO = despDAO;
    }

    @Transactional
    public void inserir(Despesa despesa){
        despDAO.inserir(despesa);
    }

    @Transactional
    public void excluir(Despesa despesa) {
        despDAO.excluir(despesa);
    }

    public Despesa buscarDespesaPorId(int cod) {
        return despDAO.buscarDespesaPorId(cod);
    }

    @Transactional
    public void alterar(Despesa despesa) {
        despDAO.alterar(despesa);
    }

    public List<Despesa> buscarListaDespesa(LocalDate dataInicio, LocalDate dataFim) {
        return despDAO.buscarListaDespesa(dataInicio, dataFim);
    }
}