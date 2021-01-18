package br.com.almode.cleanarch.usecases.usecases.usuario.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Usuario não encontrado");
    }
}
