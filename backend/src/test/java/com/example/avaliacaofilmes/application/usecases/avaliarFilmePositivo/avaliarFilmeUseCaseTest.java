package com.example.avaliacaofilmes.application.usecases.avaliarFilmePositivo;

import com.example.avaliacaofilmes.domain.exceptions.FilmeNaoEncontradoException;
import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class avaliarFilmeUseCaseTest {

    @Mock
    private IFilmesRepository repository;

    @InjectMocks
    private avaliarFilmeUseCase avaliarFilmeUseCase;

    @Test
    @DisplayName("Deve responser com uma mensagem de sucesso para o voto gostei")
    void deveResponderSucessoParaVotoPositivo() {

        int filmeId = 1;

        Map<String, Object> filme = new HashMap<>();
        filme.put("id", 1);
        filme.put("titulo","Harry Potter");
        filme.put("genero","Fantasia");
        filme.put("descricao","Lorem");
        filme.put("imagem","Lorem.com");
        filme.put("gostei",1);
        filme.put("naoGostei", 2);

        Mockito.when(repository.listarFilmesPorId(1)).thenReturn(filme);

        CadastrarFilmeResponseDTO response = avaliarFilmeUseCase.positivo(filmeId);

        assertEquals("Voto gostei feito com sucesso!", response.message());
    }

    @Test
    @DisplayName("Deve responser com uma mensagem de sucesso para o voto gostei")
    void deveResponderSucessoParaVotoNegativo() {

        int filmeId = 1;

        Map<String, Object> filme = new HashMap<>();
        filme.put("id", 1);
        filme.put("titulo","Harry Potter");
        filme.put("genero","Fantasia");
        filme.put("descricao","Lorem");
        filme.put("imagem","Lorem.com");
        filme.put("gostei",1);
        filme.put("naoGostei", 2);

        Mockito.when(repository.listarFilmesPorId(filmeId)).thenReturn(filme);

        CadastrarFilmeResponseDTO response = avaliarFilmeUseCase.positivo(filmeId);

        assertEquals("Voto gostei feito com sucesso!", response.message());
    }

    @Test
    @DisplayName("Deve lançar uma exception de filme não encontrado")
    void deveLancarUmaExceptionDeFilmeNaoEncontrado() {
        int filmeId = 1;

        Mockito.when(repository.listarFilmesPorId(1)).thenReturn(null);

        assertThrows(FilmeNaoEncontradoException.class, ()->{
            avaliarFilmeUseCase.positivo(filmeId);
            avaliarFilmeUseCase.negativo(filmeId);
        });
    }


}