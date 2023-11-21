package com.ufn.demo.repositories;

import com.ufn.demo.model.Estagiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstagiarioRepository extends JpaRepository<Estagiario, Long> {
}
