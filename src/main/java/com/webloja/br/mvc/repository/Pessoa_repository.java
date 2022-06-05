package com.webloja.br.mvc.repository;

import com.webloja.br.mvc.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface Pessoa_repository extends JpaRepository<Pessoa,Long> {

    void deleteByEmail(String email);

    Optional<Pessoa> findByEmail(String email);
}
