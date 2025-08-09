package com.example.avaliacaofilmes.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Filme {

    private int id;
    private String titulo;
    private String genero;
    private String descricao;
    private String imagem;
    private int gostei;
    private int naoGostei;

    public Filme(int id, String titulo, String genero, String descricao, String imagem, int naoGostei, int gostei) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.descricao = descricao;
        this.imagem = imagem;
        this.naoGostei = naoGostei;
        this.gostei = gostei;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getGostei() {
        return gostei;
    }

    public void setGostei(int gostei) {
        this.gostei = gostei;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getNaoGostei() {
        return naoGostei;
    }

    public void setNaoGostei(int naoGostei) {
        this.naoGostei = naoGostei;
    }

    public static Filme converter(Map<String,Object> registro){
        int id = (int) registro.get("id");

        String titulo = (String) registro.get("titulo");

        String genero = (String) registro.get("genero");

        String descricao = (String) registro.get("descricao");

        String imagem = (String) registro.get("imagem");

        int gostei = (int) registro.get("gostei");

        int naoGostei = (int) registro.get("naoGostei");

        return new Filme(id,titulo,genero,descricao,imagem,gostei,naoGostei);
    }

    public static List<Filme> converterVarios(List<Map<String,Object>> registro){
        ArrayList<Filme> lista = new ArrayList<>();
        for(Map<String,Object> reg : registro){
            lista.add(converter(reg));
        }
        return lista;
    }
}
