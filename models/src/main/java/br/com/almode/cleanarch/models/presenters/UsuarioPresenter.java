package br.com.almode.cleanarch.models.presenters;

import br.com.almode.cleanarch.models.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@AllArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UsuarioPresenter {
    UUID id;
    String nome;
    String cpf;

    public UsuarioPresenter(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
    }
}
