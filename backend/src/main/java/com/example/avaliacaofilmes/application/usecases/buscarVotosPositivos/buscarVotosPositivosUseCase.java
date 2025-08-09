package com.example.avaliacaofilmes.application.usecases.buscarVotosPositivos;

import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.BuscarVotosResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class buscarVotosPositivosUseCase implements IBuscarVotosPositivosUseCase{

    private final IFilmesRepository repository;

    public buscarVotosPositivosUseCase(
            IFilmesRepository repository
    )
    {
        this.repository = repository;
    }

    @Override
    public BuscarVotosResponseDTO executar() {
        return new BuscarVotosResponseDTO(repository.buscarVotosPositivos());
    }
}
