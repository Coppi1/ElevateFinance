package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Natureza;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Data
public class NaturezaDAO implements Serializable {

    @Inject
    @PersistenceContext
    private EntityManager entityManager;



    public List<Natureza> listarCategorias(){

         Query query = entityManager.createQuery("SELECT c FROM Natureza c", Natureza.class);

         List<Natureza> naturezaList = query.getResultList();

         return naturezaList;
    }


}
