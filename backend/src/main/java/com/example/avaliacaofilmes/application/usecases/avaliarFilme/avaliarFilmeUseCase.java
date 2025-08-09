package com.example.avaliacaofilmes.application.usecases.avaliarFilme;

import com.example.avaliacaofilmes.domain.entities.Filme;
import com.example.avaliacaofilmes.domain.exceptions.FilmeNaoEncontradoException;
import com.example.avaliacaofilmes.domain.exceptions.votoInvalidoException;
import com.example.avaliacaofilmes.domain.repositories.IFilmesRepository;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class avaliarFilmeUseCase implements IAvaliarFilmeUseCase {

    private final IFilmesRepository repository;

    public avaliarFilmeUseCase(
            IFilmesRepository repository
    )
    {
        this.repository = repository;
    }

    @Override
    public CadastrarFilmeResponseDTO executar(String tipoVoto, int filmeId) {
        boolean filmeNaoExiste = repository.listarFilmesPorId(filmeId)==null;

        if (filmeNaoExiste){
            throw new FilmeNaoEncontradoException();
        }

//        if (!"gostei".equals(tipoVoto) && !"naoGostei".equals(tipoVoto)) {
//            throw new votoInvalidoException();
//        }

        Filme filme = Filme.converter(repository.listarFilmesPorId(filmeId));

        repository.avaliarFilme(tipoVoto, filmeId);

        return new CadastrarFilmeResponseDTO("Voto feito com sucesso!");
    }
}
