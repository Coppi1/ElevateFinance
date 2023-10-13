package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.CategoriaDespesa;
import br.com.FinancePI.Entidades.Despesa;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Data
public class CategoriaDespesaDAO implements Serializable {
   // @Inject
    @PersistenceContext
    private EntityManager entityManager;



    public List<CategoriaDespesa> listarCategorias(){

         Query query = entityManager.createQuery("SELECT c FROM CategoriaDespesa c", CategoriaDespesa.class);

         List<CategoriaDespesa> categoriaDespesaList = query.getResultList();

         return categoriaDespesaList;
    }


}
