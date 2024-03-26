package br.com.samara.moreirabooks.model.autor.dtos;

import br.com.samara.moreirabooks.model.autor.Autor;

import java.time.LocalDate;

public record AutorResponseDTO(
        String nome,

        LocalDate dataNascimento,

        LocalDate dataCadastro
) {
    public AutorResponseDTO(Autor autor) {
        this(autor.getNome(), autor.getDataCadastro(),autor.getDataNascimento());
    }


}
