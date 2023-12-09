package projeto.back.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;
import projeto.back.model.Administrador;
import projeto.back.repository.AdministratorRepository;
import projeto.back.service.CookieService;


@Controller
public class LoginController {
    @Autowired
    private AdministratorRepository repo;

    @GetMapping("/login")
    public String login() {
        return "Login/login";
    }

    @PostMapping("/logar")
    public String logar(Model model, Administrador adminParam, String lembrar, HttpServletResponse response) throws IOException {
        Administrador adm = this.repo.Login(adminParam.getEmail(), adminParam.getSenha());
        if(adm != null) {
            int tempoLogado = (60*60);
            if(lembrar != null) tempoLogado = (60*60*24*365);
            CookieService.setCookie(response, "UsuarioId", String.valueOf(adm.getId()), tempoLogado);
            CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
            return "redirect:/";
        } 
        model.addAttribute("erro", "E-mail ou Senha inválidos!.");
        return "Login/login";
    }
}
