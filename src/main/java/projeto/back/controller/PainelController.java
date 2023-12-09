package projeto.back.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import projeto.back.service.CookieService;

import org.springframework.ui.Model;

@Controller
public class PainelController {
    @GetMapping("/")
    public String painel(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("nome", CookieService.getCookie(request, "nomeUsuario"));
        return "Painel/painel";
    }
}
