package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Receita;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Data;
import org.springframework.stereotype.Component;


@ViewScoped
@Component
@Data
public class receitaDAO {


    // iniciando a transação com o banco de dados
    EntityManagerFactory entityManFac = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManFac.createEntityManager();

    public void inserir(Receita receita){

        //persistindo o objeto no banco de dados
        entityManager.getTransaction().begin();
        entityManager.persist(receita);
        entityManager.getTransaction().commit();

    }

    public void excluir(Receita r){

        entityManager.getTransaction().begin();
        Receita excluir = entityManager.find(Receita.class, r.getId());
        entityManager.remove(excluir);
    }

    public Receita buscarReceitaPorId(int id){

        entityManager.getTransaction().begin();
        Receita encontrado = entityManager.find(Receita.class, id);
        return  encontrado;
    }

    public void alterar (Receita r){

        entityManager.getTransaction().commit();

    }



}
