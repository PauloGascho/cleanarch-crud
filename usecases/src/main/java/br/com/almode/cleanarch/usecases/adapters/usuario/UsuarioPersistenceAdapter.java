package br.com.almode.cleanarch.usecases.adapters.usuario;

import br.com.almode.cleanarch.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioPersistenceAdapter {
    Usuario create(Usuario usuario);
    Optional<Usuario> get(UUID idDoUsuario);
    Page<Usuario> find(Pageable pageable);

    //emplemenentado UD do CRUD
    Usuario delete(UUID idDoUsuario);

    Usuario update(Usuario usuario, UUID idDoUsuario);
}