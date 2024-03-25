package br.com.samara.moreirabooks.model.autor;

import java.time.LocalDate;

public record AutorResponseDTO(
        String nome,

        LocalDate dataNascimento,

        LocalDate dataCadastro
) {
}
