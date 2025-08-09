package com.example.avaliacaofilmes.application.usecases.buscarVotosNegativos;

import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.BuscarVotosResponseDTO;

public class buscarVotosNegativosUseCase implements IBuscarVotosNegativosUseCase{

    private final IFilmesRepository repository;

    public buscarVotosNegativosUseCase(
            IFilmesRepository repository
    )
    {
        this.repository = repository;
    }

    @Override
    public BuscarVotosResponseDTO executar() {
        return new BuscarVotosResponseDTO(repository.buscarVotosNegativos());
    }
}
