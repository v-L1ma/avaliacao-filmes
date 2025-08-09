package com.example.avaliacaofilmes.infra.web.DTOs;

import com.example.avaliacaofilmes.domain.entities.Filme;

import java.util.List;

public record ListarFilmesResponseDTO(String message, List<Filme> filmes) {
}
