package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Despesa;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
<<<<<<< HEAD
import java.time.LocalDate;
=======
import java.util.Date;
>>>>>>> parent of f8e1c57 (Testes(tentativa 1))
import java.util.List;

@Component
public class despesaDAO implements Serializable {

    public static final long serialVersionUID = 1L;
<<<<<<< HEAD

=======
>>>>>>> parent of f8e1c57 (Testes(tentativa 1))
    @PersistenceContext
    private  EntityManager entityManager;

    public void inserir(Despesa despesa){
        entityManager.persist(despesa);
    }

    public void excluir(Despesa despesa) {
        if (!entityManager.contains(despesa)) {
            despesa = entityManager.merge(despesa);
        }
        entityManager.remove(despesa);
    }

    public Despesa buscarDespesaPorId(int cod) {
        return entityManager.find(Despesa.class, cod);
    }

    public void alterar(Despesa despesa) {
        entityManager.merge(despesa);
    }

<<<<<<< HEAD
    public List<Despesa> buscarListaDespesa(LocalDate dataInicio, LocalDate dataFim) {
        TypedQuery<Despesa> query = entityManager.createQuery("SELECT d FROM Despesa d WHERE d.vencimento BETWEEN :dataInicio AND :dataFim", Despesa.class);
=======

    @Transactional
    public List<Despesa> buscarDespesasPorData(Date dataInicio, Date dataFim) {
        TypedQuery<Despesa> query = entityManager.createQuery(
                "SELECT d FROM Despesa d WHERE d.vencimento >= :dataInicio AND d.vencimento <= :dataFim", Despesa.class);
>>>>>>> parent of f8e1c57 (Testes(tentativa 1))
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);
        return query.getResultList();
    }

}





