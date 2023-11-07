package br.com.FinancePI.Controladores;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MenuController implements Serializable {

    public static final long serialVersionUID = 1L;

    public void logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        // Obtém o componente menbar
        UIComponent componente = context.getViewRoot().findComponent("menbar");

    }

}
