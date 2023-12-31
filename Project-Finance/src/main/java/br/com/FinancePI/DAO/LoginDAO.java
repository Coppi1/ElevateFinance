package br.com.FinancePI.DAO;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LoginDAO {

    private static final long serialVersionUID = 1L;

    @Inject
    @PersistenceContext
    private EntityManager entityManager;


}
