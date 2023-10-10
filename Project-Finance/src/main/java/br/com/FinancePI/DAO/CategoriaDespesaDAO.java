package br.com.FinancePI.DAO;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CategoriaDespesaDAO {
    @Inject
    @PersistenceContext
    private EntityManager entityManager;


}
