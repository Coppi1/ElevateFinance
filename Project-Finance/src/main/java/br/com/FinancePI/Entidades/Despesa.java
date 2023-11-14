package br.com.FinancePI.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Component
@Data
public class Despesa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @Temporal(TemporalType.DATE)
    private LocalDate dtVencimento;

    private String formaPGTO;

    private Double valor;

    private LocalDate dtLancamento;

    private String fornecedor;

    @ManyToOne
    private Natureza natureza;


   // @ManyToOne
   // private Fornecedor fornecedor;

}
