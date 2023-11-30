package com.lucas.ocorrencias.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cellphone;
    private String cpf;
    private String email;
    private String password;


    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets = new ArrayList<>();
}
