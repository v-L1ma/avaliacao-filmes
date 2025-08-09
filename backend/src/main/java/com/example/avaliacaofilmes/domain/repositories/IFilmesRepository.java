package com.example.avaliacaofilmes.domain.repositories;

import com.example.avaliacaofilmes.domain.entities.Filme;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeRequestDTO;

import java.util.List;
import java.util.Map;

public interface IFilmesRepository {
    void cadastrarFilme(CadastrarFilmeRequestDTO dto);

    void avaliarFilme(String tipoVoto, int filmeId);

    List<Map<String,Object>> listarFilmes();

    Map<String, Object> listarFilmesPorTitulo(String titulo);

    Map<String, Object> listarFilmesPorId(int id);

    List<Map<String,Object>> buscarVotosTotais();

    List<Map<String,Object>> buscarVotosPositivos();

    List<Map<String,Object>> buscarVotosNegativos();
}
