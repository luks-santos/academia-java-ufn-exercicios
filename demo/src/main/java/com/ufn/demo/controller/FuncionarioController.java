package com.ufn.demo.controller;

import com.ufn.demo.model.Estagiario;
import com.ufn.demo.model.Funcionario;
import com.ufn.demo.model.Gerente;
import com.ufn.demo.repositories.FuncionarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/funcionarios")
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }
}