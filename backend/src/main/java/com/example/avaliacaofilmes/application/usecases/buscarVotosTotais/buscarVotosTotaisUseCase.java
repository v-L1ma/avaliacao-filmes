package com.example.avaliacaofilmes.application.usecases.buscarVotosTotais;

import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.BuscarVotosResponseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class buscarVotosTotaisUseCase implements IBuscarVotosTotaisUseCase{

    private final IFilmesRepository repository;

    public buscarVotosTotaisUseCase(
            IFilmesRepository repository
    )
    {
        this.repository = repository;
    }

    @Override
    public BuscarVotosResponseDTO executar() {
        return new BuscarVotosResponseDTO(repository.buscarVotosTotais());
    }

}
