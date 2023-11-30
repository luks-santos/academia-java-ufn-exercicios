package com.ufn.springufnbiblioteca.repositories;

import com.ufn.springufnbiblioteca.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
