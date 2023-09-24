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

import java.util.List;


@ViewScoped
@Component
@Data
public class despesaDAO {


    @PersistenceContext
    private  EntityManager entityManager;


    @Transactional
    public void inserir(Despesa despesa){

        entityManager.persist(despesa);

    }

    public List<Despesa> buscarTodasDespesas() {
        return entityManager.createQuery("SELECT d FROM Despesa d", Despesa.class).getResultList();
    }





}
