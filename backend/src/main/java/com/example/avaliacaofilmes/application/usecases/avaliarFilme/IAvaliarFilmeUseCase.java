package com.example.avaliacaofilmes.application.usecases.avaliarFilme;

import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;

public interface IAvaliarFilmeUseCase {
    CadastrarFilmeResponseDTO executar(String tipoVoto, int filmeId);
}
