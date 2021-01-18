package br.com.almode.cleanarch.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Usuario {
    UUID id;
    @NonNull
    final String nome;
    @NonNull
    final String cpf;
}
