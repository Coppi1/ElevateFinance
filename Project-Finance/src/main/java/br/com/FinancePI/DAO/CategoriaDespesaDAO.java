package br.com.FinancePI.DAO;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class CategoriaDespesaDAO implements Serializable {
    @Inject
    @PersistenceContext
    private EntityManager entityManager;



}
