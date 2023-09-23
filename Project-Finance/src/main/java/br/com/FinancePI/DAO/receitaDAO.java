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


@ViewScoped
@Component
@Data
public class receitaDAO {

    @PersistenceContext
    private  EntityManager entityManager;


    @Transactional
    public void inserir(Receita receita){
        entityManager.persist(receita);
    }

    @Transactional
    public void excluir(Receita r){

        Receita excluir = entityManager.find(Receita.class, r.getId());

    }

    @Transactional
    public Receita buscarReceitaPorId(int id){
        Receita encontrado = entityManager.find(Receita.class, id);
        return  encontrado;
    }

    @Transactional
    public void alterar (Receita r){
        entityManager.getTransaction().commit();
    }



}
