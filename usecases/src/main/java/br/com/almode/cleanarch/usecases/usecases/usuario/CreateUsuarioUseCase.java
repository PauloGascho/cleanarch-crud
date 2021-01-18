package br.com.almode.cleanarch.usecases.usecases.usuario;

import br.com.almode.cleanarch.models.Usuario;
import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.adapters.usuario.UsuarioPersistenceAdapter;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateUsuarioUseCase {
    UsuarioPersistenceAdapter usuarioPersistenceAdapter;

    public UsuarioPresenter execute(CreateUsuarioParams createUsuarioParams){
        var usuario = new Usuario(createUsuarioParams.getNome(), createUsuarioParams.getCpf());
        var usuarioCriado = this.usuarioPersistenceAdapter.create(usuario);
        return new UsuarioPresenter(usuarioCriado);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @FieldDefaults(level=AccessLevel.PRIVATE)
    public static class CreateUsuarioParams {
        @NotNull
        String nome;
        @NonNull
        String cpf;
    }
}
