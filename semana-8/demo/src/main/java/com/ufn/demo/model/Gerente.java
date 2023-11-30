package com.ufn.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Gerente extends Funcionario {

    private String departamento;

}
