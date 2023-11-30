package com.ufn.springufnbiblioteca.service;

import com.ufn.springufnbiblioteca.model.Aluno;
import com.ufn.springufnbiblioteca.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno alunoAtualizado) {
        if (alunoRepository.existsById(id)) {
            alunoAtualizado.setId(id);
            return alunoRepository.save(alunoAtualizado);
        } else {
            throw new RuntimeException("Aluno não encontrado com ID: " + id);
        }
    }

    public void deleteAluno(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Aluno não encontrado com ID: " + id);
        }
    }
}
