package br.com.FinancePI.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
@Data
public class CategoriaDespesa {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    private String descricao;

    @OneToMany (mappedBy = "categDesp")
    private List<Despesa> listaDespesas;


}
