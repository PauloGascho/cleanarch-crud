package br.com.almode.cleanarch.usecases.usecases.usuario;

import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.adapters.usuario.UsuarioPersistenceAdapter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DeleteUsuarioUseCase {
    UsuarioPersistenceAdapter usuarioPersistenceAdapter;

    public UsuarioPresenter delete(UUID idDoUsuario) {
        var usuario = this.usuarioPersistenceAdapter.delete(idDoUsuario);
        return new UsuarioPresenter(usuario);
    }
}
