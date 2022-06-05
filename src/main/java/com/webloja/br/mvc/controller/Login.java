package com.webloja.br.mvc.controller;

import com.webloja.br.mvc.entities.Pessoa;
import com.webloja.br.mvc.service.Pessoa_service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;

@Controller
public class Login {

    private Pessoa_service service;

    public Login(Pessoa_service service){
        this.service = service;
    }

    @GetMapping(value = {"/webloja","/"})
    public String login(Model model /*, HttpServletRequest request, HttpServletResponse response*/){
        Pessoa ps = new Pessoa();
        //response.getWriter().println("abcdefg");
        model.addAttribute("pessoa", ps);
        return "login";

    }

    @PostMapping("/authentication")
    public String auth(@ModelAttribute Pessoa pessoa){

         Pessoa ps = service.find(pessoa.getEmail());
         boolean is_valid = false;

         if(ps == null){//não encontrou e-mail?
             return "redirect:/throwerror";

         } else if (ps.getSenha().equals(pessoa.getSenha())) {

             if(ps.isE_lojista()){

                 return "redirect:/produto_logista";
             }else{

                 return "redirect:/";
             }
         }else {//a senha não bate?

             return "redirect:/throwerror";
         }
    }
    @GetMapping("/throwerror")
    public String handling_error(){

        return "error_login";
    }



}


//        int val_usu = 0;
//
//        if(ps.getEmail() != null){
////valida usuario e salva a seção
//            if(ps.getSenha().equals(senha)){
//                 HttpSession session = request.getSession();
//                    session.setAttribute("e_logado",true);
//                    session.setAttribute("e_logista",ps.getElojista());
//                val_usu = 1;
//            }
//        }else val_usu = -1;
//
//        switch (val_usu){
//            case 1:
//                if(ps.getElojista()){//verifica se é logista ou cliente
//
//                    response.sendRedirect("/produtos_logista");
//                }else{
//                    response.sendRedirect("/lista_de_produtos");
//                }
//                break;
//            default: //se não retorna ao login
//                response.sendRedirect("/login_response");
//        }
//
//    }
//
//    @GetMapping("/login_response")
//    public void lg_rs(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//        var write = response.getWriter();
//        write.println("<h1>usuario ou senha incorretos!</h1>");
//        write.println("<a href = \"/login.html\">Página login</a>");
//    }
//
//}
