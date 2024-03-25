package br.com.samara.moreirabooks.repository.autor;

import br.com.samara.moreirabooks.model.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor, Long> {
}
