package com.example.avaliacaofilmes.domain.exceptions;

public class FilmeNaoEncontradoException extends RuntimeException {

    public FilmeNaoEncontradoException() {super("Nenhum filme encontrado.");}

    public FilmeNaoEncontradoException(String message) {
        super(message);
    }
}
