package br.com.samara.moreirabooks.model.autor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record AutorUpdateDTO(
        @NotBlank
        String nome
) {
}
