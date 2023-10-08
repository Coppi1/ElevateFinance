package br.com.FinancePI.Entidades;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Data
@ViewScoped
@Repository
public class tabelaDespesa {
    public interface EntidadeExemploRepository extends JpaRepository<Despesa, Integer> {
        // Você pode adicionar métodos de consulta personalizados aqui, se necessário
    }
}
