package com.example.avaliacaofilmes.infra.web.DTOs;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CadastrarFilmeRequestDTO(
        @NotBlank(message = "O título é obrigatório")
        String titulo,

        @NotBlank(message = "O gênero é obrigatório")
        String genero,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotBlank(message = "A imagem é obrigatória")
        String imagem
){}
