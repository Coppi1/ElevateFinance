package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Despesa;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Component
@Data
public class despesaDAO implements Serializable {

    public static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

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

    public List<Despesa> buscarListaDespesa(LocalDate dataInicio, LocalDate dataFim) {
        TypedQuery<Despesa> query = entityManager.createQuery("SELECT d FROM Despesa d WHERE d.vencimento BETWEEN :dataInicio AND :dataFim", Despesa.class);
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);

        return query.getResultList();
    }
}





