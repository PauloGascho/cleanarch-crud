package br.com.almode.cleanarch.usecases.usecases.usuario;

import br.com.almode.cleanarch.models.Usuario;
import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.adapters.usuario.UsuarioPersistenceAdapter;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateUsuarioUseCase {
    UsuarioPersistenceAdapter usuarioPersistenceAdapter;

    public UsuarioPresenter update(UpdateUsuarioParams params, UUID idDoUsuario) {
        var usuarioBuscado = new Usuario(params.getNome(), params.getCpf());
        var usuario = this.usuarioPersistenceAdapter.update(usuarioBuscado, idDoUsuario);
        return new UsuarioPresenter(usuario);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class UpdateUsuarioParams {
        @NonNull
        String nome;

        @NonNull
        String cpf;
    }
}
