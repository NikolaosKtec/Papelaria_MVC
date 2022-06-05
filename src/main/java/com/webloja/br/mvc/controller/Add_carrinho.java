//package com.webloja.br.mvc.controller;
//
//
//
//import com.webloja.br.mvc.entities.Produto;
//import com.webloja.br.mvc.service.Produto_service;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//
//@Controller
//public class Add_carrinho {
//
//    private Produto_service service;
//
//    public  Add_carrinho(Produto_service service){
//        this.service = service;
//    }
//
//    @GetMapping("/add_carrinho")
//    public void add_carrinho(HttpServletRequest request, HttpServletResponse response) throws IOException,
//                                                                                        ServletException {
//
//        HttpSession session = request.getSession();
//
//        Produto p;
//        Cookie[] requestCookies = request.getCookies();
//        boolean e_logado = false;
//
//        p = service.find(Integer.parseInt(request.getParameter("id")));
//
//
//        Cookie carrinho = new Cookie("carrinho", "");
//        carrinho.setMaxAge(60 * 60 * 24 * 7);
//        boolean achouCarrinho = false;
//
//        if (requestCookies != null) {
//            for (var item : requestCookies) {
//                if (item.getName().equals("carrinho")) {
//                    achouCarrinho = true;
//                    carrinho = item;
//                    break;
//                }
//            }
//        }
//
//
//        if (!p.equals(null)) {
//
//            if (achouCarrinho) {
//                String value = carrinho.getValue();
//                carrinho.setValue(value + p.getId() + "|");
//            } else {
//                carrinho.setValue(p.getId() + "|");
//            }
////            }else {
////                response.addCookie(carrinho);
//            //response.getWriter().println("Id inexistente");
////            }
//
//            response.addCookie(carrinho);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/lista_de_produtos");
//            dispatcher.forward(request, response);
//
//        }
//    }
//}
