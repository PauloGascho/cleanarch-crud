package br.com.almode.cleanarch.persistence.entities;

import br.com.almode.cleanarch.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "usuario",
    indexes = {
        @Index(name = "idx_nome", columnList = "nome"),
        @Index(name = "idx_cpf", columnList = "cpf")
    })
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioEntity {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    UUID id;
    String nome;
    String cpf;

    public static UsuarioEntity fromDomain(Usuario usuario){
        return new UsuarioEntity(
            usuario.getId(),
            usuario.getNome(),
            usuario.getCpf());
    }

    public Usuario toDomain(){
        return new Usuario(
            this.getId(),
            this.getNome(),
            this.getCpf());
    }

    public void changeState(Usuario usuario) {

        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
    }

}
