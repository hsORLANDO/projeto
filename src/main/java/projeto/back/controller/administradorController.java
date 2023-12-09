package projeto.back.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import jakarta.servlet.http.HttpServletResponse;
import projeto.back.model.Administrador;
import projeto.back.service.AdministradorService;
import projeto.back.service.CookieService;


@Controller
public class administradorController {

    private final AdministradorService administradorService;

    @Autowired
    public administradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping("/administradores")
    public String painelAdm(Model model) {
        List<Administrador> administradores = administradorService.listarAdministradores();
        model.addAttribute("administradores", administradores);
        return "administradores/painelAdm";
    }

    @GetMapping("/administradores/novo")
    public String novo(Model model) {
        return "administradores/novo";
    }

    @PostMapping("/administradores/novo")
    public String novoAdministrador(@ModelAttribute Administrador administrador) {
        administradorService.novoAdministrador(administrador);
        return "redirect:/administradores";
    }
    
    
    @PostMapping("/administradores/criar")
    public String criar(Administrador administrador) {
        administradorService.criarAdministrador(administrador);
        return "redirect:/administradores";
    }
    
    @DeleteMapping("/administradores/{id}")
    public String excluirAdministrador(@PathVariable int id) {
        administradorService.excluirAdministrador(id);
        return "redirect:/administradores";
    }

    
    @GetMapping("/administradores/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Administrador> admin = administradorService.encontrarAdministradorPorId(id);
        try {
            model.addAttribute("administrador", admin.get());
        } catch (Exception e) {
            return "redirect:/administradores";
        }
        return "/administradores/editar";
    }
    
    @PutMapping("/administradores/{id}/atualizar")
    public String atualizarAdministrador(@PathVariable int id, @ModelAttribute("administrador") Administrador administrador) {
        administradorService.atualizarAdministrador(administrador);
        return "redirect:/administradores";
    }
    

    @GetMapping("/sair")
    public String sair(HttpServletResponse response) throws IOException{
            CookieService.setCookie(response, "UsuarioId", "", 0);
            return "redirect:/login";
        } 
}
