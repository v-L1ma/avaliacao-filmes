package com.example.avaliacaofilmes.application.usecases.buscarVotosNegativos;

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
class BuscarVotosNegativosUseCaseTest {

    @Mock
    private IFilmesRepository repository;

    @InjectMocks
    private buscarVotosNegativosUseCase buscarVotosNegativosUseCase;

    @Test
    @DisplayName("Deve retornar uma quantidade de votos negativos")
    void deveRetornarUmaQuantidadeDeVotosNegativos() {
        Mockito.when(repository.buscarVotosNegativos()).thenReturn(10);

        BuscarVotosResponseDTO response = buscarVotosNegativosUseCase.executar();

        assertEquals(10, response.votos());
    }
}