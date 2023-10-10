package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Receita;
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
public class ReceitaDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void inserir(Receita receita){

        entityManager.persist(receita);

    }


    @Transactional
    public void excluir(Receita receita) {

        if (!entityManager.contains(receita)) {
            receita = entityManager.merge(receita);
        }
        entityManager.remove(receita);
    }

    @Transactional
    public Receita buscarReceitaPorId(int cod) {
        return entityManager.find(Receita.class, cod);
    }

    @Transactional
    public void alterar(Receita receita) {
        entityManager.merge(receita);
    }


    @Transactional
    public List<Receita> buscarListaReceita(LocalDate dataInicio, LocalDate dataFim) {
        TypedQuery<Receita> query = entityManager.createQuery("SELECT d FROM Receita d WHERE d.dtLancamento BETWEEN :dataInicio AND :dataFim", Receita.class);
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);

        return query.getResultList();
    }
}










