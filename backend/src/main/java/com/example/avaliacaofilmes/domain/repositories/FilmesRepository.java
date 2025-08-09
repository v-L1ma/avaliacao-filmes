package com.example.avaliacaofilmes.domain.repositories;

import com.example.avaliacaofilmes.infra.web.DTOs.CadastrarFilmeRequestDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void avaliarFilme(String tipoVoto, int filmeId) {
        String sql;

        if (tipoVoto.equals("naoGostei")){
            sql = "UPDATE filmes set naoGostei = naoGostei+1 WHERE id=?;";
        } else {
            sql = "UPDATE filmes set gostei= gostei + 1 WHERE id=?;";
        }

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
    public List<Map<String, Object>> buscarVotosTotais() {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> buscarVotosPositivos() {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> buscarVotosNegativos() {
        return List.of();
    }
}
