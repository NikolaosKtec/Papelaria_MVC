package com.webloja.br.mvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {
    @Id
    private int id;

    @Column(length = 32)
    private String nome;

    @Column(columnDefinition = "Numeric(6,0) ")
    private int quantidade;

    @Column(columnDefinition = "Numeric(6,2) ")
    private double preco;

    @Column(/*name = "descricao"*/length = 38,nullable = true)
    private String descricao;
}
