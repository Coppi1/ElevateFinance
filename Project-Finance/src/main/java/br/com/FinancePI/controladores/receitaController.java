package br.com.FinancePI.controladores;

import br.com.FinancePI.DAO.receitaDAO;
import br.com.FinancePI.Entidades.Receita;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class receitaController {

    @Autowired
    private receitaDAO rDao;

    private Receita receita = new Receita();

    public void salvar() {

        rDao.inserir(receita);
        receita = new Receita();
        Messages.addFlashGlobalInfo("Registro salvo com sucesso");
    }

    public void excluir() {

            if (receita.getId() != null) {

                Receita receitaParaExcluir = rDao.buscarReceitaPorId(receita.getId());
                if (receitaParaExcluir != null) {
                    rDao.excluir(receitaParaExcluir);
                    Messages.addFlashGlobalInfo("Registro excluído com sucesso");
                } else {
                    Messages.addFlashGlobalError("Registro não encontrado");
                }
            } else {
                Messages.addFlashGlobalError("ID da receita não especificado");
            }
            receita = new Receita();
        }

    public void buscarReceita() {

        if (receita.getId() != null) {
            Receita receitaEncontrada = rDao.buscarReceitaPorId(receita.getId());
            if (receitaEncontrada != null) {
                receita = receitaEncontrada;
            } else {
                Messages.addFlashGlobalError("Registro não encontrado");
            }
        } else {
            Messages.addFlashGlobalError("ID da receita não especificado");
        }
    }

    public void alterarReceita() {
        rDao.alterar(receita);
        Messages.addFlashGlobalInfo("Registro alterado com sucesso");
        receita = new Receita();
    }
}















