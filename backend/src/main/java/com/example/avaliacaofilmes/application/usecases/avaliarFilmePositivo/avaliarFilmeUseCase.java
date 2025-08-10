package com.example.avaliacaofilmes.application.usecases.avaliarFilmePositivo;

import com.example.avaliacaofilmes.domain.entities.Filme;
import com.example.avaliacaofilmes.domain.exceptions.FilmeNaoEncontradoException;
import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class avaliarFilmeUseCase implements IAvaliarFilmeUseCase {

    private final IFilmesRepository repository;

    public avaliarFilmeUseCase(
            IFilmesRepository repository
    )
    {
        this.repository = repository;
    }

    @Override
    public CadastrarFilmeResponseDTO positivo(int filmeId) {
        boolean filmeNaoExiste = repository.listarFilmesPorId(filmeId)==null;

        if(filmeNaoExiste) {
            throw new FilmeNaoEncontradoException();
        }

        repository.avaliarFilmePositivo(filmeId);

        return new CadastrarFilmeResponseDTO("Voto gostei feito com sucesso!");
    }

    @Override
    public CadastrarFilmeResponseDTO negativo(int filmeId) {
        boolean filmeNaoExiste = repository.listarFilmesPorId(filmeId)==null;

        if(filmeNaoExiste) {
            throw new FilmeNaoEncontradoException();
        }

        repository.avaliarFilmeNegativo(filmeId);

        return new CadastrarFilmeResponseDTO("Voto não gostei feito com sucesso!");
    }
}
