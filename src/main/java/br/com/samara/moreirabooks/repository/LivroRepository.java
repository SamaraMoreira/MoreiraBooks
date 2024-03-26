package br.com.samara.moreirabooks.repository;

import br.com.samara.moreirabooks.model.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
