package br.com.FinancePI.Entidades;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Component
@Data
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    private String descricao;

    private LocalDate vencimento;

    private String formaPgto;

    private Double valor;

    private String fornecedor;


}
