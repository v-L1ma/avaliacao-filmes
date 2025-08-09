package com.example.avaliacaofilmes.application.usecases.cadastrarFilme;

import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeRequestDTO;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;

public interface ICadastrarFilmeUseCase {
    CadastrarFilmeResponseDTO executar(CadastrarFilmeRequestDTO dto);
}
