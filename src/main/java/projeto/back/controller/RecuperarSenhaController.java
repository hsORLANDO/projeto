package projeto.back.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import projeto.back.model.Administrador;
import projeto.back.repository.AdministratorRepository;

@Controller
public class RecuperarSenhaController {
    @Autowired
    private AdministratorRepository repo;

    @GetMapping("/recuperar_senha")
    public String Recuperar_Senha() {
        return "Recuperar_Senha/recuperar_senha";
    }

    @PostMapping("/criar")
    public String Criar_Senha(Administrador administrador) {
        repo.save(administrador);
        return "redirect:/login";
    }
    
}
