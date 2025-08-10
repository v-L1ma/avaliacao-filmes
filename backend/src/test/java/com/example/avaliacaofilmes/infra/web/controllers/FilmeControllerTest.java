package com.example.avaliacaofilmes.infra.web.controllers;

import com.example.avaliacaofilmes.application.usecases.avaliarFilmePositivo.avaliarFilmeUseCase;
import com.example.avaliacaofilmes.application.usecases.buscarVotosNegativos.buscarVotosNegativosUseCase;
import com.example.avaliacaofilmes.application.usecases.buscarVotosPositivos.buscarVotosPositivosUseCase;
import com.example.avaliacaofilmes.application.usecases.buscarVotosTotais.buscarVotosTotaisUseCase;
import com.example.avaliacaofilmes.application.usecases.cadastrarFilme.CadastrarFilmeUseCase;
import com.example.avaliacaofilmes.application.usecases.listarFilmes.listarFilmesUseCase;
import com.example.avaliacaofilmes.domain.entities.Filme;
import com.example.avaliacaofilmes.infra.web.DTOs.BuscarVotosResponseDTO;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeRequestDTO;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;
import com.example.avaliacaofilmes.infra.web.DTOs.ListarFilmesResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(FilmeController.class)
class FilmeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private listarFilmesUseCase listarFilmesUseCase;
    @MockitoBean
    private CadastrarFilmeUseCase cadastrarFilmeUseCase;
    @MockitoBean
    private avaliarFilmeUseCase avaliarFilmeUseCase;
    @MockitoBean
    private buscarVotosTotaisUseCase buscarVotosTotaisUseCase;
    @MockitoBean
    private buscarVotosPositivosUseCase buscarVotosPositivosUseCase;
    @MockitoBean
    private buscarVotosNegativosUseCase buscarVotosNegativosUseCase;

    @Test
    @DisplayName("Deve retornar uma response de sucesso")
    void listarFilmes() {

        Filme filme = new Filme(
                1,
                "Harry Potter e a Pedra Filosofal",
                "Fantasia",
                "Um jovem bruxo descobre seus poderes e vai para Hogwarts.",
                "https://exemplo.com/imagens/harry-potter.jpg",
                1,
                2
        );

        Mockito.when(listarFilmesUseCase.executar()).thenReturn(new ListarFilmesResponseDTO("Filmes listados com sucesso!", List.of(filme)));

        try {
            mockMvc.perform(get("/filmes")).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Deve retornar uma response de sucesso")
    void cadastrarFilme() {

        CadastrarFilmeRequestDTO dto = new CadastrarFilmeRequestDTO(
                "Harry Potter e a Pedra Filosofal",
                "Fantasia",
                "Um jovem bruxo descobre seus poderes e vai para Hogwarts.",
                "https://exemplo.com/imagens/harry-potter.jpg"
        );

        Mockito.when(cadastrarFilmeUseCase.executar(dto)).thenReturn(new CadastrarFilmeResponseDTO("Filmes listados com sucesso!"));

        try {
            mockMvc.perform(post("/filmes")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(dto)))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void avaliarFilmePositivo() {

        Mockito.when(avaliarFilmeUseCase.positivo(1)).thenReturn(new CadastrarFilmeResponseDTO("Voto gostei feito com sucesso!"));

        try {
            mockMvc.perform(post("/filmes/votos/positivos/1"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void avaliarFilmeNegativo() {
        Mockito.when(avaliarFilmeUseCase.negativo(1)).thenReturn(new CadastrarFilmeResponseDTO("Voto não gostei feito com sucesso!"));

        try {
            mockMvc.perform(post("/filmes/votos/negativos/1"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void buscarVotosTotais() {

        Mockito.when(buscarVotosTotaisUseCase.executar()).thenReturn(new BuscarVotosResponseDTO(1));

        try {
            mockMvc.perform(get("/filmes/votos")).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void buscarVotosPositivos() {
        Mockito.when(buscarVotosPositivosUseCase.executar()).thenReturn(new BuscarVotosResponseDTO(1));

        try {
            mockMvc.perform(get("/filmes/votos/positivos")).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void buscarVotosNegativos() {
        Mockito.when(buscarVotosPositivosUseCase.executar()).thenReturn(new BuscarVotosResponseDTO(1));

        try {
            mockMvc.perform(get("/filmes/votos/negativos")).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}