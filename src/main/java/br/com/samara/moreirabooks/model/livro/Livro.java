package br.com.samara.moreirabooks.model.livro;

import br.com.samara.moreirabooks.model.autor.Autor;
import br.com.samara.moreirabooks.model.livro.dtos.LivroInputDTO;
import br.com.samara.moreirabooks.model.livro.dtos.LivroUpdateDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @ManyToOne
    private Autor autor;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private LocalDate dataLancamento;

    public Livro(LivroInputDTO livroDTO) {
        this.nome = livroDTO.nome();
        this.descricao = livroDTO.descricao();
        this.valor = livroDTO.valor();
        this.genero = livroDTO.genero();
        this.dataLancamento = LocalDate.now();
    }

    public void update(LivroUpdateDTO livroUpdateDTO) {
        this.descricao = livroUpdateDTO.descricao();
        this.valor = livroUpdateDTO.valor();
    }
}
