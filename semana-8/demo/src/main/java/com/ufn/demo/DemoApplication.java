package com.ufn.demo;

import com.ufn.demo.model.Estagiario;
import com.ufn.demo.model.Funcionario;
import com.ufn.demo.model.Gerente;
import com.ufn.demo.repositories.EstagiarioRepository;
import com.ufn.demo.repositories.FuncionarioRepository;
import com.ufn.demo.repositories.GerenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final FuncionarioRepository funcionarioRepository;
    private final GerenteRepository gerenteRepository;
    private final EstagiarioRepository estagiarioRepository;

    public DemoApplication(FuncionarioRepository funcionarioRepository,
                           GerenteRepository gerenteRepository,
                           EstagiarioRepository estagiarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.gerenteRepository = gerenteRepository;
        this.estagiarioRepository = estagiarioRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Gerente gerente1 = new Gerente();
        gerente1.setNome("Gerente 1");
        gerente1.setSalario(8000.0);
        gerente1.setDepartamento("RH");
        gerenteRepository.save(gerente1);

        Estagiario estagiario = new Estagiario();
        estagiario.setNome("Estagiario 1");
        estagiario.setSalario(2000.0);
        estagiario.setHorasSemanais(20);
        estagiarioRepository.save(estagiario);
    }
}
