package com.example.avaliacaofilmes.infra.web.controllers;

import com.example.avaliacaofilmes.application.usecases.avaliarFilmePositivo.IAvaliarFilmeUseCase;
import com.example.avaliacaofilmes.application.usecases.buscarVotosNegativos.IBuscarVotosNegativosUseCase;
import com.example.avaliacaofilmes.application.usecases.buscarVotosPositivos.IBuscarVotosPositivosUseCase;
import com.example.avaliacaofilmes.application.usecases.buscarVotosTotais.IBuscarVotosTotaisUseCase;
import com.example.avaliacaofilmes.application.usecases.cadastrarFilme.ICadastrarFilmeUseCase;
import com.example.avaliacaofilmes.application.usecases.listarFilmes.IListarFilmesUseCase;
import com.example.avaliacaofilmes.infra.web.DTOs.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final IListarFilmesUseCase listarFilmesUseCase;
    private final ICadastrarFilmeUseCase cadastrarFilmeUseCase;
    private final IAvaliarFilmeUseCase avaliarFilmeUseCase;
    private final IBuscarVotosTotaisUseCase buscarVotosTotaisUseCase;
    private final IBuscarVotosPositivosUseCase buscarVotosPositivosUseCase;
    private final IBuscarVotosNegativosUseCase buscarVotosNegativosUseCase;

    @Autowired
    public FilmeController(
            IListarFilmesUseCase listarFilmesUseCase,
            ICadastrarFilmeUseCase cadastrarFilmeUseCase,
            IAvaliarFilmeUseCase avaliarFilmeUseCase,
            IBuscarVotosTotaisUseCase buscarVotosTotaisUseCase,
            IBuscarVotosPositivosUseCase buscarVotosPositivosUseCase,
            IBuscarVotosNegativosUseCase buscarVotosNegativosUseCase
    ){
        this.listarFilmesUseCase = listarFilmesUseCase;
        this.cadastrarFilmeUseCase = cadastrarFilmeUseCase;
        this.avaliarFilmeUseCase = avaliarFilmeUseCase;
        this.buscarVotosTotaisUseCase = buscarVotosTotaisUseCase;
        this.buscarVotosPositivosUseCase = buscarVotosPositivosUseCase;
        this.buscarVotosNegativosUseCase = buscarVotosNegativosUseCase;
    }

    @GetMapping
    public ResponseEntity<ListarFilmesResponseDTO> listarFilmes(){
        return ResponseEntity.ok(listarFilmesUseCase.executar());
    }

    @PostMapping
    public ResponseEntity<CadastrarFilmeResponseDTO> cadastrarFilme(@RequestBody @Valid CadastrarFilmeRequestDTO dto){
        return ResponseEntity.ok(cadastrarFilmeUseCase.executar(dto));
    }

    @PostMapping("/votos/positivos/{filmeId}")
    public ResponseEntity<CadastrarFilmeResponseDTO> avaliarFilmePositivo(@PathVariable int filmeId){
        return ResponseEntity.ok(avaliarFilmeUseCase.positivo(filmeId));
    }

    @PostMapping("/votos/negativos/{filmeId}")
    public ResponseEntity<CadastrarFilmeResponseDTO> avaliarFilmeNegativo(@PathVariable int filmeId){
        return ResponseEntity.ok(avaliarFilmeUseCase.negativo(filmeId));
    }

    @GetMapping("votos")
    public ResponseEntity<BuscarVotosResponseDTO> buscarVotosTotais(){

        return ResponseEntity.ok(buscarVotosTotaisUseCase.executar());
    }

    @GetMapping("votos/positivos")
    public ResponseEntity<BuscarVotosResponseDTO> buscarVotosPositivos(){

        return ResponseEntity.ok(buscarVotosPositivosUseCase.executar());
    }

    @GetMapping("votos/negativos")
    public ResponseEntity<BuscarVotosResponseDTO> buscarVotosNegativos(){

        return ResponseEntity.ok(buscarVotosNegativosUseCase.executar());
    }

}
