package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.CategoriaDespesa;
import br.com.FinancePI.Entidades.CategoriaReceita;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Data
public class CategoriaReceitaDAO implements Serializable {

    @Inject
    @PersistenceContext
    private EntityManager entityManager;



    public List<CategoriaReceita> listarCategorias(){

        Query query = entityManager.createQuery("SELECT r FROM CategoriaReceita r", CategoriaReceita.class);

        List<CategoriaReceita> categoriaReceitaList = query.getResultList();

        return categoriaReceitaList;
    }


}
