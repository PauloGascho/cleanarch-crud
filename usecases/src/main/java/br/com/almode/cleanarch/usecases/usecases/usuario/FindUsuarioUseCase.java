package br.com.almode.cleanarch.usecases.usecases.usuario;

import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.adapters.usuario.UsuarioPersistenceAdapter;
import br.com.almode.cleanarch.usecases.usecases.usuario.exceptions.UserNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FindUsuarioUseCase {
    UsuarioPersistenceAdapter usuarioPersistenceAdapter;

    public UsuarioPresenter get(UUID idDoUsuario) {
        return this.usuarioPersistenceAdapter.get(idDoUsuario)
                .map(UsuarioPresenter::new)
                .orElseThrow(UserNotFoundException::new);
    }
    public Page<UsuarioPresenter> find(Pageable pageable) {
        return this.usuarioPersistenceAdapter
                .find(pageable)
                .map(UsuarioPresenter::new);
    }
}