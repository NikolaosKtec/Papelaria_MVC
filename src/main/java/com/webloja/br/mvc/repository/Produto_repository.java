package com.webloja.br.mvc.repository;

import com.webloja.br.mvc.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Produto_repository extends JpaRepository<Produto,Integer> {
}
