package com.example.avaliacaofilmes.application.usecases.buscarVotosNegativos;

import com.example.avaliacaofilmes.infra.web.DTOs.BuscarVotosResponseDTO;

public interface IBuscarVotosNegativosUseCase {
    BuscarVotosResponseDTO executar();
}
