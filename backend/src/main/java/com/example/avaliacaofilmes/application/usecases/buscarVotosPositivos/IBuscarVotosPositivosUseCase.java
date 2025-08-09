package com.example.avaliacaofilmes.application.usecases.buscarVotosPositivos;

import com.example.avaliacaofilmes.infra.web.DTOs.BuscarVotosResponseDTO;

public interface IBuscarVotosPositivosUseCase {
    BuscarVotosResponseDTO executar();
}
