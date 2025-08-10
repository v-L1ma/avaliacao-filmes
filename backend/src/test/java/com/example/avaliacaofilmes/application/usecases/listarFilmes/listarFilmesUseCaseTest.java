package com.example.avaliacaofilmes.application.usecases.listarFilmes;

import com.example.avaliacaofilmes.domain.entities.Filme;
import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.ListarFilmesResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ListarFilmesUseCaseTest {

    @Mock
    private IFilmesRepository repository;

    @InjectMocks
    private listarFilmesUseCase listarFilmesUseCase;

    @Test
    @DisplayName("Deve retonar uma lista com os filmes")
    void deveRetornarUmaListaComOsFilmes() {

        List<Map<String, Object>> filmes = new ArrayList<>();

        Map<String, Object> filme1 = new HashMap<>();
        filme1.put("id", 1);
        filme1.put("titulo", "Harry Potter");
        filme1.put("genero", "Fantasia");
        filme1.put("descricao", "Lorem");
        filme1.put("imagem", "Lorem.com");
        filme1.put("gostei", 1);
        filme1.put("naogostei", 2);

        filmes.add(filme1);

        List<Filme> filmesEsperados = Filme.converterVarios(filmes);

        Mockito.when(repository.listarFilmes()).thenReturn(filmes);

        ListarFilmesResponseDTO response = listarFilmesUseCase.executar();

        ListarFilmesResponseDTO expectedResponse = new ListarFilmesResponseDTO("Filmes listados com sucesso!", filmesEsperados);

        assertEquals(expectedResponse.message(), response.message());
        assertEquals(expectedResponse.filmes().size(), response.filmes().size());
    }
}