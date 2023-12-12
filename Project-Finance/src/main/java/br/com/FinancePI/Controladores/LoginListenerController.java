package br.com.FinancePI.Controladores;

import br.com.FinancePI.Entidades.Usuario;
import jakarta.faces.application.NavigationCase;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.faces.view.ViewScoped;
import jakarta.websocket.Session;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;

import java.io.Serializable;
import java.util.logging.Logger;


@ViewScoped
@Component
@Data
public abstract class LoginListenerController implements PhaseListener {


        private static final Logger logger = Logger.getLogger("global");
        private static final long serialVersionUID = 1L;



        /**
         * Creates a new instance of PhasePrinterListener
         */
        public LoginListenerController() {
        }

        @Override
        public void afterPhase(PhaseEvent event) {
            System.out.println("Fase: "+event.getPhaseId());

            //Inicia o contexto phase
            FacesContext fc = event.getFacesContext();

            String pagAtual = fc.getViewRoot().getViewId();

            boolean isLogado = (pagAtual.lastIndexOf("/META-INF/resources/Inicio/telaLogin.xhtml") > -1);


            FacesContext facesContext = FacesContext.getCurrentInstance();
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, "/META-INF/resources/Lancamento/telaLancamentoDespesa.xhtml");
        }

        @Override
        public void beforePhase(PhaseEvent event) {


        }

        @Override
        public PhaseId getPhaseId() {
            return PhaseId.RESTORE_VIEW;
        }

}

