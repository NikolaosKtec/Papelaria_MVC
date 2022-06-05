//package com.webloja.br.mvc.controller;
//
//import com.webloja.br.mvc.entities.Produto;
//import com.webloja.br.mvc.service.Produto_service;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//@Controller
//public class CarrinhoController {
//
//    private Produto_service service;
//
//    public  CarrinhoController(Produto_service service){
//        this.service = service;
//    }
//
//    @GetMapping(value = "/carrinho")
//    public String carrinho(HttpServletRequest request, HttpServletResponse response, Model model) {
//
//        response.setContentType("text/html");
//        Produto p = new Produto();
//
//
//            boolean achou = false;
//
//            Cookie carrinho = new Cookie("carrinho","");
//            carrinho.setMaxAge(60*60*24*7);
//
//            Cookie[] requestCookies = request.getCookies();
//            if (requestCookies != null) {
//                for (var item: requestCookies){
//                    if(item.getName().equals("carrinho")){
//                        achou = true;
//                        carrinho = item;
//                        break;
//                    }
//                }
//            }
//
//
//        ArrayList<Produto> lista_carrinho = new ArrayList<>();
//
//            if(achou) {
//                StringTokenizer tokenizer = new StringTokenizer(carrinho.getValue(), "|");
//
//
//                while (tokenizer.hasMoreTokens()) {
//
//                    p = service.find(Integer.parseInt((tokenizer.nextToken())));
//
//                    lista_carrinho.add(p);
//                }
//                model.addAttribute("carrinho",lista_carrinho);
//
//            }else{
//                p.setNome("Carrinho vazio!");
//                lista_carrinho.add(p);
//                model.addAttribute("carrinho",lista_carrinho);
//            }
//        return "carrinho";
//    }
//}
