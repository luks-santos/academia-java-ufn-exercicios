package com.ufn.springufnbiblioteca.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;

    @OneToMany(mappedBy = "livro")
    private Set<Emprestimo> emprestimos;
}
