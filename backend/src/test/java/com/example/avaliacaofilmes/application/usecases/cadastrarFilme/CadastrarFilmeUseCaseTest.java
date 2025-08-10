package com.example.avaliacaofilmes.application.usecases.cadastrarFilme;

import com.example.avaliacaofilmes.domain.exceptions.FilmeJaCadastradoException;
import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeRequestDTO;
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
class CadastrarFilmeUseCaseTest {

    @Mock
    private IFilmesRepository repository;

    @InjectMocks
    private CadastrarFilmeUseCase cadastrarFilmeUseCase;

    @Test
    @DisplayName("Deve retornar uma mensagem de sucesso")
    void deveRetornarUmaMensagemDeSucesso() {

        CadastrarFilmeRequestDTO dto = new CadastrarFilmeRequestDTO(
                "Harry Potter e a Pedra Filosofal",
                "Fantasia",
                "Um jovem bruxo descobre seus poderes e vai para Hogwarts.",
                "https://exemplo.com/imagens/harry-potter.jpg"
        );

        Mockito.when(repository.listarFilmesPorTitulo(dto.titulo())).thenReturn(null);

        CadastrarFilmeResponseDTO response = cadastrarFilmeUseCase.executar(dto);

        assertEquals("Filme cadastrado com sucesso", response.message());
    }

    @Test
    @DisplayName("Deve lancar uma exception de filme ja cadastrado")
    void deveLancarUmaExceptionDeFilmeJaCadastrado() {

        CadastrarFilmeRequestDTO dto = new CadastrarFilmeRequestDTO(
                "Harry Potter e a Pedra Filosofal",
                "Fantasia",
                "Um jovem bruxo descobre seus poderes e vai para Hogwarts.",
                "https://exemplo.com/imagens/harry-potter.jpg"
        );

        Map<String, Object> filme1 = new HashMap<>();
        filme1.put("id", 1);
        filme1.put("titulo", "Harry Potter");
        filme1.put("genero", "Fantasia");
        filme1.put("descricao", "Lorem");
        filme1.put("imagem", "Lorem.com");
        filme1.put("gostei", 1);
        filme1.put("naogostei", 2);

        Mockito.when(repository.listarFilmesPorTitulo(dto.titulo())).thenReturn(filme1);

        assertThrows(FilmeJaCadastradoException.class, ()->{
            cadastrarFilmeUseCase.executar(dto);
        });
    }
}