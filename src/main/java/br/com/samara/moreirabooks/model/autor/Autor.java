package br.com.samara.moreirabooks.model.autor;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "autores")
@NoArgsConstructor
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private LocalDate dataCadastro;

    public Autor(AutorInputDTO autorDTO) {
        this.nome = autorDTO.nome();
        this.dataNascimento = autorDTO.dataNascimento();
        this.dataCadastro = LocalDate.now();
    }

    public void update (AutorUpdateDTO autorUpdateDTO){
        this.nome = autorUpdateDTO.nome();
    }

}
