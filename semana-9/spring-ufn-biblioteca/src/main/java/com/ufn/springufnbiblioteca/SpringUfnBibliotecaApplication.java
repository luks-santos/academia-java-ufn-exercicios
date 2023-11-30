package com.ufn.springufnbiblioteca;

import com.ufn.springufnbiblioteca.model.Aluno;
import com.ufn.springufnbiblioteca.model.Emprestimo;
import com.ufn.springufnbiblioteca.model.Livro;
import com.ufn.springufnbiblioteca.repositories.AlunoRepository;
import com.ufn.springufnbiblioteca.repositories.EmprestimoRepository;
import com.ufn.springufnbiblioteca.repositories.LivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SpringUfnBibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUfnBibliotecaApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(LivroRepository livroRepository, AlunoRepository alunoRepository,
                                   EmprestimoRepository emprestimoRepository)
    {
        return args -> {
            Livro livro1 = new Livro();
            livro1.setTitulo("Java: The Complete Reference");
            livro1.setAutor("Herbert Schildt");

            Livro livro2 = new Livro();
            livro2.setTitulo("Clean Code: A Handbook of Agile Software Craftsmanship");
            livro2.setAutor("Robert C. Martin");

            livroRepository.save(livro1);
            livroRepository.save(livro2);

            Aluno aluno1 = new Aluno();
            aluno1.setNome("João Silva");
            aluno1.setIdade(20);
            aluno1.setMatricula("12345");

            Aluno aluno2 = new Aluno();
            aluno2.setNome("Maria Oliveira");
            aluno2.setIdade(22);
            aluno2.setMatricula("67890");

            alunoRepository.save(aluno1);
            alunoRepository.save(aluno2);


            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setAluno(aluno1);
            emprestimo.setLivro(livro1);
            emprestimo.setDataEmprestimo(LocalDate.now());

            emprestimoRepository.save(emprestimo);
        };
    }
}
