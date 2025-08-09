package com.example.avaliacaofilmes.domain.exceptions;

public class FilmeJaCadastradoException extends RuntimeException {

    public FilmeJaCadastradoException() {
        super("Não é possivel cadastrar, pois esse filme já foi cadastrado!");
    }

    public FilmeJaCadastradoException(String message) {
        super(message);
    }
}
