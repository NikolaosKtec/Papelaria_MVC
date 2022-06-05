package com.webloja.br.mvc.service;


import com.webloja.br.mvc.entities.Pessoa;
import com.webloja.br.mvc.repository.Pessoa_repository;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class Pessoa_service {
    private Pessoa_repository repository;

    public  Pessoa_service(Pessoa_repository repository){
        this.repository = repository;
    }

    public void insert(Pessoa p){
        repository.save(p);
    }

    public void remove(String email){
        repository.deleteByEmail(email);
    }

    public void update(Pessoa p){
        repository.saveAndFlush(p);
    }

    public Pessoa find(String email){
        Optional<Pessoa> pessoaOptional = repository.findByEmail(email);
        if(pessoaOptional.isPresent()){
            return pessoaOptional.get();
        }else{
            return null;
        }
    }

    public List<Pessoa> findAll(){
        return repository.findAll();
    }
}
