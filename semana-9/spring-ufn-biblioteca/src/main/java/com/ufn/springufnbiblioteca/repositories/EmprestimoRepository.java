package com.ufn.springufnbiblioteca.repositories;

import com.ufn.springufnbiblioteca.model.Emprestimo;
import com.ufn.springufnbiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findByLivroAndDataDevolucaoIsNull(Livro livro);
}
