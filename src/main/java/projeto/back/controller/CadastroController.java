package projeto.back.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.ui.Model;
import jakarta.validation.Valid;
import projeto.back.model.Administrador;
import projeto.back.repository.AdministratorRepository;

@Controller
public class CadastroController {
    @Autowired
    private AdministratorRepository repo;

    @GetMapping("/cadastro")
    public String cadastro() {
        return "Cadastro/cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Administrador administrador, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        // Verificar se o email já existe
        Optional<Administrador> existingAdmin = repo.findByEmail(administrador.getEmail());
        
        if (existingAdmin.isPresent()) {
            bindingResult.rejectValue("email", "erro", "Email já cadastrado!");
            model.addAttribute("erroEmail", "Email já cadastrado!");
        }
    
        if (bindingResult.hasErrors()) {
            // Adicione o BindingResult ao modelo para que o Thymeleaf possa acessá-lo
            model.addAttribute("bindingResult", bindingResult);
            // Adicione o objeto administrador ao modelo para preservar os valores preenchidos no formulário
            return "Cadastro/cadastro";
        }
    
        // Se não houver erros de validação, salve o administrador e redirecione para a página de login
        repo.save(administrador);
        return "redirect:/login";
    }
    

}
    


