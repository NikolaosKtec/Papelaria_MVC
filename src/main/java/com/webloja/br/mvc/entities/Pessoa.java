package com.webloja.br.mvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

    //@Column(name = "email",length = 32, unique = true)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(nullable = true)
    private long id;

    @NotBlank
    @Column(length = 32,unique = true)
    private String email;

    @NotBlank
    @Column(length = 32)
    private String nome;

    @NotBlank
    @Column(length = 32)
    private String senha;

    @Column(/*name = "e_lojista",nullable = true,*/ columnDefinition = "boolean DEFAULT false")
    private boolean e_lojista;
}
