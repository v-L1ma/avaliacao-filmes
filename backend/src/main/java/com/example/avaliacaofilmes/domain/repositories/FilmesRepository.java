package com.example.avaliacaofilmes.domain.repositories;

import com.example.avaliacaofilmes.domain.exceptions.votoInvalidoException;
import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeRequestDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class FilmesRepository implements IFilmesRepository {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    public void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void cadastrarFilme(CadastrarFilmeRequestDTO dto) {
        String sql = "INSERT INTO filmes(titulo,genero,descricao,imagem,gostei,naoGostei) VALUES(?,?,?,?,?,?)";
        Object[] parametros = new Object[6];
        parametros[0] = dto.titulo();
        parametros[1] = dto.genero();
        parametros[2] = dto.descricao();
        parametros[3] = dto.imagem();
        parametros[4] = 0;
        parametros[5] = 0;

        jdbc.update(sql, parametros);

    }

    @Override
    public void avaliarFilmePositivo(int filmeId) {
        String sql = "UPDATE filmes set gostei = gostei + 1 WHERE id = ?;";
        jdbc.update(sql, filmeId);
    }

    @Override
    public void avaliarFilmeNegativo(int filmeId) {
        String sql = "UPDATE filmes set naogostei = naogostei + 1 WHERE id = ?;";
        jdbc.update(sql, filmeId);
    }

    @Override
    public List<Map<String, Object>> listarFilmes() {
        String sql = "SELECT * FROM filmes;";
        return jdbc.queryForList(sql);
    }

    @Override
    public Map<String, Object> listarFilmesPorTitulo(String titulo) {
        try {
            String sql = "SELECT * FROM filmes WHERE titulo=?;";
            return jdbc.queryForMap(sql, titulo);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Map<String, Object> listarFilmesPorId(int id) {
        try {
            String sql = "SELECT * FROM filmes WHERE id=?;";
            return jdbc.queryForMap(sql, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int buscarVotosTotais() {
        String sql = "SELECT SUM(gostei + naoGostei) FROM filmes";
        return jdbc.queryForObject(sql, Integer.class);
    }

    @Override
    public int buscarVotosPositivos() {
        String sql = "SELECT SUM(gostei) FROM filmes";
        return jdbc.queryForObject(sql, Integer.class);
    }

    @Override
    public int buscarVotosNegativos() {
        String sql = "SELECT SUM(naoGostei) FROM filmes";
        return jdbc.queryForObject(sql, Integer.class);
    }
}
