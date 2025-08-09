package com.example.avaliacaofilmes.application.usecases.cadastrarFilme;

import com.example.avaliacaofilmes.domain.entities.Filme;
import com.example.avaliacaofilmes.domain.exceptions.FilmeJaCadastradoException;
import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeRequestDTO;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastrarFilmeUseCase implements ICadastrarFilmeUseCase{
    private final IFilmesRepository repository;

    public CadastrarFilmeUseCase(
            IFilmesRepository repository
    )
    {
       this.repository = repository;
    }

    @Override
    public CadastrarFilmeResponseDTO executar(CadastrarFilmeRequestDTO dto) {

        boolean filmeExiste = repository.listarFilmesPorTitulo(dto.titulo())!=null;

        if(filmeExiste) {
            throw new FilmeJaCadastradoException();
        }

        repository.cadastrarFilme(dto);

        return new CadastrarFilmeResponseDTO("Filme cadastrado com sucesso");
    }
}
