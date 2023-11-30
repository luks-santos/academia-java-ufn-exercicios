package com.ufn.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Estagiario extends  Funcionario {

    private int horasSemanais;
}
