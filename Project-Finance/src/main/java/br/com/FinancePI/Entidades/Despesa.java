package br.com.FinancePI.Entidades;

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

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    private String descricao;

    private Date vencimento;

    private String formaPgto;

    private Double valor;

    private String fornecedor;


}
