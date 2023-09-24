package br.com.FinancePI.Entidades;

import jakarta.faces.view.ViewScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Data
@ViewScoped
@Component
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;
    private String descricao;
    private LocalDate vencimento;
    private String formaPgto;
    private Double valor;
    private String fornecedor;

}
