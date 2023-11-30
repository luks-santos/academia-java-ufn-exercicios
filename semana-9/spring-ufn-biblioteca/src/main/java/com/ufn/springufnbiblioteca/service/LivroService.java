package com.ufn.springufnbiblioteca.service;

import com.ufn.springufnbiblioteca.model.Livro;
import com.ufn.springufnbiblioteca.repositories.LivroRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> encontrarPorID(Long id) {
        return livroRepository.findById(id);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Livro> buscarPorAutor(String autor) {
        return livroRepository.findByAutorContainingIgnoreCase(autor);
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {
        if (livroRepository.existsById(id)) {
            livroAtualizado.setId(id);
            return livroRepository.save(livroAtualizado);
        } else {
            throw new RuntimeException("Livro não encontrado com ID: " + id);
        }
    }

    public void deletar(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
        } else {
            throw new RuntimeException("Livro não encontrado com ID: " + id);
        }
    }
}
