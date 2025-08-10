package com.example.avaliacaofilmes.application.usecases.avaliarFilmePositivo;

import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;

public interface IAvaliarFilmeUseCase {
    CadastrarFilmeResponseDTO negativo(int filmeId);

    CadastrarFilmeResponseDTO positivo(int filmeId);
}
