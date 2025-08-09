package com.example.avaliacaofilmes.infra.web.handlers;

import com.example.avaliacaofilmes.domain.exceptions.FilmeJaCadastradoException;
import com.example.avaliacaofilmes.domain.exceptions.FilmeNaoEncontradoException;
import com.example.avaliacaofilmes.domain.exceptions.votoInvalidoException;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(FilmeJaCadastradoException.class)
    public ResponseEntity<CadastrarFilmeResponseDTO> handlerFilmeJaCadastradoException(FilmeJaCadastradoException e){
        logger.warn(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new CadastrarFilmeResponseDTO(e.getMessage()));
    }

    @ExceptionHandler(FilmeNaoEncontradoException.class)
    public ResponseEntity<CadastrarFilmeResponseDTO> handlerFilmeNaoEncontradoException(FilmeNaoEncontradoException e){
        logger.warn(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new CadastrarFilmeResponseDTO(e.getMessage()));
    }

    @ExceptionHandler(votoInvalidoException.class)
    public ResponseEntity<CadastrarFilmeResponseDTO> handlervotoInvalidoException(votoInvalidoException e){
        logger.warn(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new CadastrarFilmeResponseDTO(e.getMessage()));
    }
}
