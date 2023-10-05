package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Despesa;
import br.com.FinancePI.Entidades.Receita;
import jakarta.enterprise.inject.Typed;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Component
public class despesaDAO implements Serializable {

    public static final long serialVersionUID = 1L;
    @PersistenceContext
    private  EntityManager entityManager;


    @Transactional
    public void inserir(Despesa despesa){

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
    public List<Despesa> buscarDespesasPorData(Date dataInicio, Date dataFim) {
        TypedQuery<Despesa> query = entityManager.createQuery(
                "SELECT d FROM Despesa d WHERE d.vencimento >= :dataInicio AND d.vencimento <= :dataFim", Despesa.class);
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);
        return query.getResultList();
    }

}








