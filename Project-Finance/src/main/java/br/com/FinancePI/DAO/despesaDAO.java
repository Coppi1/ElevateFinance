package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Despesa;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Component;


@ViewScoped
@Component
@Data
public class despesaDAO {


    EntityManagerFactory entityManFac = Persistence.createEntityManagerFactory("default");


    EntityManager entityManager = entityManFac.createEntityManager();


    public void inserir(Despesa despesa){
        entityManager.getTransaction().begin();
        entityManager.persist(despesa);
        entityManager.getTransaction().commit();
    }





}
