package com.example.avaliacaofilmes.application.usecases.listarFilmes;

import com.example.avaliacaofilmes.domain.entities.Filme;
import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.ListarFilmesResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class listarFilmesUseCase implements IListarFilmesUseCase {

    private final IFilmesRepository repository;

    public listarFilmesUseCase(
            IFilmesRepository repository
    )
    {
        this.repository = repository;
    }

    @Override
    public ListarFilmesResponseDTO executar() {

        List<Filme> filmes = Filme.converterVarios(repository.listarFilmes());

        return new ListarFilmesResponseDTO("Filmes listados com sucesso!", filmes);
    }
}
