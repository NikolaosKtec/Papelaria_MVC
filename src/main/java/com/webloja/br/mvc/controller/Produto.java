package com.webloja.br.mvc.controller;

import com.webloja.br.mvc.service.Produto_service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class Produto {

        private Produto_service service;

        public Produto(Produto_service service){
            this.service = service;
        }

        @GetMapping(value ="/produto_logista")
        public String produtos_logista(Model model) {

            List<com.webloja.br.mvc.entities.Produto> lista_de_produtos = service.findAll();
            model.addAttribute("produtosL", lista_de_produtos);

            return "produtos_do_logista";

        }

        @PostMapping("/remove_p")
    public String remove(HttpServletRequest request){

            var id = request.getParameter("id");
            service.remove(Integer.parseInt(id));
            
            return "produtos_do_logista";
        }




}
