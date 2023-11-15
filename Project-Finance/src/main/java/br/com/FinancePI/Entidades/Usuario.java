package br.com.FinancePI.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Entity
@Component
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String email;

    private String senha;

    private String endereco;

    private Integer cpf;

    private Integer cel;

    private String estado;

    private String cidade;

    private Integer cnpj;


    @OneToMany conta_Banca



}
