package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Despesa;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Component
@Data
public class DespesaDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void inserir(Despesa despesa){

        LocalDate dataLancamento = LocalDate.now();
        despesa.setDtLancamento(dataLancamento);


        entityManager.persist(despesa);


    }


    @Transactional
    public void excluir(Despesa despesa) {

        if (!entityManager.contains(despesa)) {
            despesa = entityManager.merge(despesa);
        }
        entityManager.remove(despesa);
    }

    @Transactional
    public Despesa buscarDespesaPorId(int cod) {
        return entityManager.find(Despesa.class, cod);
    }

    @Transactional
    public void alterar(Despesa despesa) {
        entityManager.merge(despesa);
    }


    @Transactional
    public List<Despesa> buscarListaDespesa(LocalDate dataInicio, LocalDate dataFim) {
        TypedQuery<Despesa> query = entityManager.createQuery("SELECT d FROM Despesa d WHERE d.dtVencimento BETWEEN :dataInicio AND :dataFim", Despesa.class);
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);

        return query.getResultList();
    }
}








