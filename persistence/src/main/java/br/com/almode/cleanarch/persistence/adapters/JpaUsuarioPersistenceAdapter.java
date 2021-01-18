package br.com.almode.cleanarch.persistence.adapters;

import br.com.almode.cleanarch.models.Usuario;
import br.com.almode.cleanarch.persistence.entities.UsuarioEntity;
import br.com.almode.cleanarch.persistence.repositories.UsuarioRepository;
import br.com.almode.cleanarch.usecases.adapters.usuario.UsuarioPersistenceAdapter;
import br.com.almode.cleanarch.usecases.usecases.usuario.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JpaUsuarioPersistenceAdapter implements UsuarioPersistenceAdapter {
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario){
        var usuarioEntity = UsuarioEntity.fromDomain(usuario);
        return this.usuarioRepository
            .save(usuarioEntity)
            .toDomain();
    }

    @Override
    public Optional<Usuario> get(UUID idDoUsuario) {
        return this.usuarioRepository
                .findById(idDoUsuario)
                .map(UsuarioEntity::toDomain);
    }

    @Override
    public Page<Usuario> find(Pageable pageable) {
        return this.usuarioRepository
                .findAll(pageable)
                .map(UsuarioEntity::toDomain);
    }

    @Override
    public Usuario update(Usuario usuario, UUID idDoUsuario){
        var usuarioEntity = this.usuarioRepository
                .findById(idDoUsuario)
                .orElseThrow(UserNotFoundException::new);
        usuarioEntity.changeState(usuario);
        return this.usuarioRepository
                .save(usuarioEntity)
                .toDomain();
    }

    @Override
    public Usuario delete(UUID idDoUsuario) {
        var usuarioEntity = this.usuarioRepository
                .findById(idDoUsuario)
                .orElseThrow(UserNotFoundException::new);
        this.usuarioRepository.deleteById(idDoUsuario);
        return usuarioEntity.toDomain();
    }
}
