package com.example.avaliacaofilmes.domain.exceptions;

public class votoInvalidoException extends RuntimeException {
    public votoInvalidoException() {
        super("Por favor escolha uma opção válida para votar.");
    }
    public votoInvalidoException(String message) {
        super(message);
    }
}
