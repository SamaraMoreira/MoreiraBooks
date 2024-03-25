package br.com.samara.moreirabooks.controller;

import br.com.samara.moreirabooks.model.autor.Autor;
import br.com.samara.moreirabooks.model.autor.AutorInputDTO;
import br.com.samara.moreirabooks.model.autor.AutorResponseDTO;
import br.com.samara.moreirabooks.model.autor.AutorUpdateDTO;
import br.com.samara.moreirabooks.repository.autor.AutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository repository;

    @GetMapping
    public List<AutorResponseDTO> index(){
       return  repository.findAll()
                .stream()
                .map(autor -> new AutorResponseDTO(autor))
                .toList();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<AutorResponseDTO> get(@PathVariable Long id){
        var autor = repository.getReferenceById(id);
        return ResponseEntity.ok(new AutorResponseDTO(autor));
    }


    @PostMapping
    public ResponseEntity create(@RequestBody @Valid AutorInputDTO autorDTO){
        Autor autor = new Autor(autorDTO);
        Autor autorSaved = repository.save(autor);
        return ResponseEntity.created(buildUri(autorSaved)).build();
    }

    @PutMapping(("/{id}"))
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid AutorUpdateDTO dadosAutor){
        var autor = repository.getReferenceById(id);
        autor.update(dadosAutor);
        return ResponseEntity.ok(new AutorResponseDTO(autor));

    }
    private URI buildUri(Autor autor){
        var path = "/"+autor.getId();
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(path)
                .build()
                .toUri();
    }
}
