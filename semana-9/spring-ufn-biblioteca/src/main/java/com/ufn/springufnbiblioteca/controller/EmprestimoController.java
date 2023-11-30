package com.ufn.springufnbiblioteca.controller;

import com.ufn.springufnbiblioteca.model.Emprestimo;
import com.ufn.springufnbiblioteca.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/esprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Emprestimo> findAll() {
        return emprestimoService.buscarTodos();
    }

    @PostMapping("/emprestar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Emprestimo emprestarLivro(@RequestParam Long alunoId, @RequestParam Long livroId) {
        return emprestimoService.emprestarLivro(alunoId, livroId);
    }

    @PutMapping("/devolver/{emprestimoId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Emprestimo devolverLivro(@PathVariable Long emprestimoId) {
        return emprestimoService.devolverLivro(emprestimoId);
    }

    @DeleteMapping("/{emprestimoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long emprestimoId) {
        emprestimoService.delete(emprestimoId);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
