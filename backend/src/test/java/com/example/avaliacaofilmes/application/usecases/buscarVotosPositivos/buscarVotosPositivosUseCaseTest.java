package com.example.avaliacaofilmes.application.usecases.buscarVotosPositivos;

import com.example.avaliacaofilmes.application.usecases.buscarVotosNegativos.buscarVotosNegativosUseCase;
import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.BuscarVotosResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BuscarVotosPositivosUseCaseTest {

    @Mock
    private IFilmesRepository repository;

    @InjectMocks
    private buscarVotosPositivosUseCase buscarVotosPositivosUseCase;

    @Test
    @DisplayName("Deve retornar uma quantidade de votos Positivos")
    void deveRetornarUmaQuantidadeDeVotosPositivos() {
        Mockito.when(repository.buscarVotosPositivos()).thenReturn(10);

        BuscarVotosResponseDTO response = buscarVotosPositivosUseCase.executar();

        assertEquals(10, response.votos());
    }
}