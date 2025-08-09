package com.example.avaliacaofilmes.infra.web.controllers;

import com.example.avaliacaofilmes.application.usecases.avaliarFilme.IAvaliarFilmeUseCase;
import com.example.avaliacaofilmes.application.usecases.cadastrarFilme.ICadastrarFilmeUseCase;
import com.example.avaliacaofilmes.application.usecases.listarFilmes.IListarFilmesUseCase;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeRequestDTO;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;
import com.example.avaliacaofilmes.infra.web.DTOs.ListarFilmesResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final IListarFilmesUseCase listarFilmesUseCase;
    private final ICadastrarFilmeUseCase cadastrarFilmeUseCase;
    private final IAvaliarFilmeUseCase avaliarFilmeUseCase;

    @Autowired
    public FilmeController(
            IListarFilmesUseCase listarFilmesUseCase,
            ICadastrarFilmeUseCase cadastrarFilmeUseCase,
            IAvaliarFilmeUseCase avaliarFilmeUseCase
    ){
        this.listarFilmesUseCase = listarFilmesUseCase;
        this.cadastrarFilmeUseCase = cadastrarFilmeUseCase;
        this.avaliarFilmeUseCase = avaliarFilmeUseCase;
    }

    @GetMapping
    public ResponseEntity<ListarFilmesResponseDTO> listarFilmes(){
        return ResponseEntity.ok(listarFilmesUseCase.executar());
    }

    @PostMapping
    public ResponseEntity<CadastrarFilmeResponseDTO> cadastrarFilme(@RequestBody @Valid CadastrarFilmeRequestDTO dto){
        return ResponseEntity.ok(cadastrarFilmeUseCase.executar(dto));
    }

    @PostMapping("/votos/{filmeId}")
    public ResponseEntity<CadastrarFilmeResponseDTO> avaliarFilme(@RequestBody String tipoVoto, @PathVariable int filmeId){
        return ResponseEntity.ok(avaliarFilmeUseCase.executar(tipoVoto, filmeId));
    }

    @GetMapping("votos")
    public ResponseEntity<String> buscarVotosTotais(){
        return ResponseEntity.ok("oi");
    }

    @GetMapping("votos/positivos")
    public ResponseEntity<String> buscarVotosPositivos(){
        return ResponseEntity.ok("oi");
    }

    @GetMapping("votos/negativos")
    public ResponseEntity<String> buscarVotosNegativos(){
        return ResponseEntity.ok("oi");
    }

}
