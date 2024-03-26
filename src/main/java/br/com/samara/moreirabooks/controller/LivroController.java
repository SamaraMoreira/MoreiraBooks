package br.com.samara.moreirabooks.controller;

import br.com.samara.moreirabooks.model.livro.Livro;
import br.com.samara.moreirabooks.model.livro.dtos.LivroInputDTO;
import br.com.samara.moreirabooks.model.livro.dtos.LivroResponseDTO;
import br.com.samara.moreirabooks.model.livro.dtos.LivroUpdateDTO;
import br.com.samara.moreirabooks.repository.AutorRepository;
import br.com.samara.moreirabooks.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @GetMapping
    public List<LivroResponseDTO> index(){
        return repository.findAll().stream().map( livro -> new LivroResponseDTO(livro)).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        var livro = repository.getReferenceById(id);
        return ResponseEntity.ok(new LivroResponseDTO(livro));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid LivroInputDTO livroDTO){
        var autor = autorRepository.getReferenceById(livroDTO.idAutor());
        var livro = new Livro(livroDTO);
        livro.setAutor(autor);
        repository.save(livro);
        return ResponseEntity.created(buildUri(livro)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid LivroUpdateDTO livroUpdateDTO){
        var livro = repository.getReferenceById(id);
        livro.update(livroUpdateDTO);
        repository.save(livro);
        return ResponseEntity.ok(new LivroResponseDTO(livro));

    }

    private URI buildUri(Livro livro){
        var path = "/"+livro.getId();
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(path)
                .build()
                .toUri();
    }
}
