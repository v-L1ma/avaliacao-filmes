package com.example.avaliacaofilmes.application.usecases.buscarVotosTotais;

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
class BuscarVotosTotaisUseCaseTest {

    @Mock
    private IFilmesRepository filmesRepository;

    @InjectMocks
    private buscarVotosTotaisUseCase buscarVotosTotaisUseCase;

    @Test
    @DisplayName("Deve retornar uma quantidade de votos no total")
    void deveRetornarUmaQuantidadeDeVotosTotal() {
        Mockito.when(filmesRepository.buscarVotosTotais()).thenReturn(10);

        BuscarVotosResponseDTO response = buscarVotosTotaisUseCase.executar();

        assertEquals(10, response.votos());
    }
}