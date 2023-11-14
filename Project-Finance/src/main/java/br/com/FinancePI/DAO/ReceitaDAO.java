package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Despesa;
import br.com.FinancePI.Entidades.Receita;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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
    private  EntityManager entityManager;


    @Transactional
    public void inserir(Receita receita){
        LocalDate dataLancamento = LocalDate.now();
        receita.setDataLancamento(dataLancamento);

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
    public Receita buscarReceitaPorId(int id) {
        return entityManager.find(Receita.class, id);
    }

    @Transactional
    public void alterar(Receita r) {
        entityManager.merge(r);
    }

    @Transactional
    public List<Receita> buscarListaReceita(LocalDate dataInicio, LocalDate dataFim) {
        TypedQuery<Receita> query = entityManager.createQuery("SELECT r FROM Receita r WHERE r.dataLancamento BETWEEN :dataInicio AND :dataFim", Receita.class);
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);

        return query.getResultList();
    }

}









