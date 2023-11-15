package br.com.FinancePI.Entidades;

import jakarta.faces.view.ViewScoped;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Component
@Data
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @Temporal(TemporalType.DATE)
    private LocalDate dataLancamento;

    private Double valor;

    private String FormaPGTO;

    @ManyToOne
    private Natureza natureza;



}
