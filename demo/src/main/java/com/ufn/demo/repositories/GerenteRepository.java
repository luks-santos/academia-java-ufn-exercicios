package com.ufn.demo.repositories;

import com.ufn.demo.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
}
