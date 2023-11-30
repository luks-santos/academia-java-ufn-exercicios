package com.ufn.springufnbiblioteca.controller;

import com.ufn.springufnbiblioteca.model.Livro;
import com.ufn.springufnbiblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Livro> findAll() {
        return livroService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        Optional<Livro> livroOptional = livroService.encontrarPorID(id);

        return livroOptional.map(livro -> new ResponseEntity<>(livro, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscarPorTitulo")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Livro> buscarPorTitulo(@RequestParam String titulo) {
        return livroService.buscarPorTitulo(titulo);
    }

    @GetMapping("/buscarPorAutor")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Livro> buscarPorAutor(@RequestParam String autor) {
        return livroService.buscarPorAutor(autor);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Livro salvarLivro(@RequestBody @Valid Livro livro) {
        return livroService.salvar(livro);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody @Valid Livro livroAtualizado) {
        return livroService.atualizar(id, livroAtualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletar(id);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
