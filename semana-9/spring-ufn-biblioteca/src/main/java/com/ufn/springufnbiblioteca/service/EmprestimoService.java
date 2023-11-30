package com.ufn.springufnbiblioteca.service;


import com.ufn.springufnbiblioteca.model.Aluno;
import com.ufn.springufnbiblioteca.model.Emprestimo;
import com.ufn.springufnbiblioteca.model.Livro;
import com.ufn.springufnbiblioteca.repositories.AlunoRepository;
import com.ufn.springufnbiblioteca.repositories.EmprestimoRepository;
import com.ufn.springufnbiblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final AlunoRepository alunoRepository;

    public EmprestimoService(
            EmprestimoRepository emprestimoRepository,
            LivroRepository livroRepository,
            AlunoRepository alunoRepository
    ) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<Emprestimo> buscarTodos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo emprestarLivro(Long alunoId, Long livroId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + alunoId));

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + livroId));

        // Verifica se o livro já está emprestado
        if (livroEstaEmprestado(livro)) {
            throw new RuntimeException("Livro já está emprestado.");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setAluno(aluno);
        emprestimo.setLivro(livro);

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolverLivro(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com ID: " + emprestimoId));

        if (emprestimo.getDataDevolucao() != null) {
            throw new RuntimeException("Livro já foi devolvido.");
        }
        emprestimo.setDataDevolucao(LocalDate.now());

        return emprestimoRepository.save(emprestimo);
    }

    public void delete(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com ID: " + emprestimoId));

        emprestimoRepository.delete(emprestimo);
    }

    private boolean livroEstaEmprestado(Livro livro) {
        List<Emprestimo> emprestimos = emprestimoRepository.findByLivroAndDataDevolucaoIsNull(livro);
        return !emprestimos.isEmpty();
    }
}
