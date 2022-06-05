package com.webloja.br.mvc.controller;

import com.webloja.br.mvc.entities.Pessoa;
import com.webloja.br.mvc.entities.Produto;
import com.webloja.br.mvc.repository.Pessoa_repository;
import com.webloja.br.mvc.repository.Produto_repository;
import com.webloja.br.mvc.service.Pessoa_service;
import com.webloja.br.mvc.service.Produto_service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Cadastro {

    Produto_service service_p;
    Pessoa_service service_pessoa;

    public Cadastro(Produto_service service_p,Pessoa_service service_pessoa){
        this.service_p = service_p;
        this.service_pessoa = service_pessoa;
    }

    @GetMapping("/cadastro_produtos")
    public  String cadastro_de_produtos(Model model){

        Produto produto = new Produto();
        model.addAttribute("produto",produto);
        return "cadastroProdutos";
    }

    @PostMapping("save_produto")
    public String save_produto(@ModelAttribute Produto p){

            service_p.insert(p);

        return "redirect:/produto_logista";
    }

    @GetMapping("/cadastro")
    public String cadastrar(Model model){
        Pessoa pessoa = new Pessoa();


        model.addAttribute("pessoa",pessoa);

        return "cadastrar";
    }



    @PostMapping("/save_pessoa")
    public String save_pessoa(@ModelAttribute Pessoa p){

        service_pessoa.insert(p);

        return "redirect:/webloja";
    }
}
