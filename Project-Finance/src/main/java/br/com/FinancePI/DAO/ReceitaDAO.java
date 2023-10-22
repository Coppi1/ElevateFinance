package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Receita;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@Data
public class ReceitaDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private  EntityManager entityManager;


    @Transactional
    public void inserir(Receita receita){
        entityManager.persist(receita);
    }

    @Transactional
    public void excluir(Receita r) {

        if (!entityManager.contains(r)) {
            r = entityManager.merge(r);
        }
        entityManager.remove(r);
    }


    @Transactional
    public Receita buscarReceitaPorId(int id) {
        return entityManager.find(Receita.class, id);
    }

    @Transactional
    public void alterar(Receita r) {
        entityManager.merge(r);
    }
}






