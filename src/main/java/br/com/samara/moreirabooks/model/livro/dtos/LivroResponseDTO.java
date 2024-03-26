package br.com.samara.moreirabooks.model.livro.dtos;

import br.com.samara.moreirabooks.model.autor.Autor;
import br.com.samara.moreirabooks.model.livro.Genero;
import br.com.samara.moreirabooks.model.livro.Livro;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LivroResponseDTO (
        String nome,
        String descricao,
        Autor autor,
        BigDecimal valor,
        Genero genero,
        LocalDate dataLancamento
){
    public LivroResponseDTO(Livro livro) {
        this(livro.getNome(),livro.getDescricao(),livro.getAutor(),livro.getValor(),livro.getGenero(),livro.getDataLancamento());
    }
}
