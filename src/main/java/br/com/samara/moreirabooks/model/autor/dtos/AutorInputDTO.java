package br.com.samara.moreirabooks.model.autor.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;


public record AutorInputDTO(

        @NotBlank
        String nome,

        @Past
        LocalDate dataNascimento,

        LocalDate dataCadastro
) {
}
