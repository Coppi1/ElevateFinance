package br.com.FinancePI.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Component
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String endereco;

    private String cep;

    private String estado;

    private String email;

    private Integer celular;

    private String senha;

    private Integer cpf;

    private Integer cnpj;

    private Integer contaBancario;

    @Temporal(TemporalType.DATE)
    private LocalDate dataInclusao;
}
