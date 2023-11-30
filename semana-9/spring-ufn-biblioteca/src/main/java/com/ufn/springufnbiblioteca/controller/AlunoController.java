package com.ufn.springufnbiblioteca.controller;

import com.ufn.springufnbiblioteca.model.Aluno;
import com.ufn.springufnbiblioteca.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAll() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        return alunoService.findById(id)
                .map(aluno -> new ResponseEntity<>(aluno, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno saveAluno(@RequestBody @Valid Aluno aluno) {
        return alunoService.saveAluno(aluno);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno updateAluno(@PathVariable Long id, @RequestBody @Valid Aluno alunoAtualizado) {
        return alunoService.updateAluno(id, alunoAtualizado);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
