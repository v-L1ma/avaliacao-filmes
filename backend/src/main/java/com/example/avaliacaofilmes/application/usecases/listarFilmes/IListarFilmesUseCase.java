package com.example.avaliacaofilmes.application.usecases.listarFilmes;

import com.example.avaliacaofilmes.infra.web.DTOs.ListarFilmesResponseDTO;

public interface IListarFilmesUseCase {
   ListarFilmesResponseDTO executar();
}
