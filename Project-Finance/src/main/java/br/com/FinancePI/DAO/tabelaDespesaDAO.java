package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Despesa;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Data
@ViewScoped
@Component
@Service
public class tabelaDespesaDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Despesa> buscarTodasDespesas() {
        return entityManager.createQuery("SELECT d FROM Despesa d", Despesa.class).getResultList();
    }
}


