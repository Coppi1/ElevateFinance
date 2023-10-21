package br.com.FinancePI.Controladores;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@EqualsAndHashCode
@Component
@Data
@ViewScoped
public class UsuarioController implements Serializable {


    public static final long serialVersionUID = 1L;

}
