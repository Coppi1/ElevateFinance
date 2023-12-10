package br.com.FinancePI.DAO;

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
    public Usuario buscarUsuarioId(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Transactional
    public void alterarUsuario(Usuario u) {
        entityManager.merge(u);
    }

    public Usuario buscarPorSenhaEmail(String email, String senha) {

        String buscar = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha";
        Query pesquisa = entityManager.createQuery(buscar);
        pesquisa.setParameter("email", email);
        pesquisa.setParameter("senha", senha);
        List<Usuario> usuarios = pesquisa.getResultList();

        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        }
        return null;

    }

}
