package br.com.FinancePI.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Entity
@Component
@Data
public class CategoriaDespesa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    private String descricao;

    @OneToMany (mappedBy = "categoriaDespesa")
    private List<Despesa> listaDespesas;


}
