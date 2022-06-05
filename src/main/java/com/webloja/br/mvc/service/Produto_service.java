package com.webloja.br.mvc.service;

import com.webloja.br.mvc.entities.Produto;
import com.webloja.br.mvc.repository.Produto_repository;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class Produto_service {
    private Produto_repository repository;

    public Produto_service( Produto_repository repository){
        this.repository = repository;
    }

    public void insert(Produto p){
        repository.save(p);
    }

    public void remove(int id){
        repository.deleteById(id);
    }

    public void update(Produto p){
        repository.saveAndFlush(p);
    }

    public Produto find(int id){
        Optional<Produto> produtoOptional = repository.findById(id);
        if(produtoOptional.isPresent()){
            return produtoOptional.get();
        }else{
            return null;
        }
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }
}
