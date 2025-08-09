package com.example.avaliacaofilmes.application.usecases.buscarVotosTotais;

import com.example.avaliacaofilmes.infra.web.DTOs.BuscarVotosResponseDTO;

public interface IBuscarVotosTotaisUseCase {
   BuscarVotosResponseDTO executar();
}
