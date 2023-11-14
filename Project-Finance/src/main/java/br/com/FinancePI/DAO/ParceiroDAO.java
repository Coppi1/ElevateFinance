package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Parceiro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class ParceiroDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserir(Parceiro parceiro){
        entityManager.persist(parceiro);
    }

    @Transactional
    public void editar(Parceiro parceiro){
        entityManager.merge(parceiro);
    }

    @Transactional
    public void excluir(Parceiro parceiro){
        if(!entityManager.contains(parceiro)){
            parceiro = entityManager.merge(parceiro);
        }
        entityManager.remove(parceiro);
    }


}
