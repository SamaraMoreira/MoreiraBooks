package br.com.samara.moreirabooks.model.livro.dtos;

import br.com.samara.moreirabooks.model.autor.Autor;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record LivroUpdateDTO(

        @NotBlank
        String descricao,

        @NotNull @Positive
        BigDecimal valor
) {
}
