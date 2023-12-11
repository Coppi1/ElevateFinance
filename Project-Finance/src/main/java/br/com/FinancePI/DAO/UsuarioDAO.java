package br.com.FinancePI.DAO;

import br.com.FinancePI.Entidades.Despesa;
import br.com.FinancePI.Entidades.Usuario;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Component
@Data
public class UsuarioDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void inserirUsuario(Usuario usuario) {
        LocalDate dataInclusao = LocalDate.now();
        usuario.setDataInclusao(dataInclusao);
        entityManager.persist(usuario);
    }


    @Transactional
    public void excluirUsuario(Usuario usuario) {
        if (!entityManager.contains(usuario)) {
            usuario = entityManager.merge(usuario);
        }
        entityManager.remove(usuario);
    }
    @Transactional
    public Usuario buscaPorEmail(String email){
        return entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                .setParameter("email", email)
                .getSingleResult();
    }

}
