package br.com.FinancePI.Entidades;

<<<<<<< HEAD
import com.sun.istack.NotNull;
import jakarta.annotation.ManagedBean;
=======
>>>>>>> parent of f8e1c57 (Testes(tentativa 1))
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

<<<<<<< HEAD

=======
>>>>>>> parent of f8e1c57 (Testes(tentativa 1))
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;


    private String descricao;

<<<<<<< HEAD
    @Temporal(TemporalType.DATE)
    private LocalDate vencimento;
=======
    private Date vencimento;
>>>>>>> parent of f8e1c57 (Testes(tentativa 1))

    private String formaPgto;


    private Double valor;


    private String fornecedor;


}
