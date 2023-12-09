package projeto.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import projeto.back.model.Administrador;
import projeto.back.repository.AdministratorRepository;

@Service
public class AdministradorService {

    private final AdministratorRepository repository;

    @Autowired
    public AdministradorService(AdministratorRepository repository) {
        this.repository = repository;
    }

    public List<Administrador> listarAdministradores() {
        return (List<Administrador>) repository.findAll();
    }

    public Optional<Administrador> encontrarAdministradorPorId(int id) {
        return repository.findById(id);
    }

    public void novoAdministrador(Administrador administrador) {
        repository.save(administrador);
    }

    public void criarAdministrador(Administrador administrador) {
        repository.save(administrador);
    }

    public void excluirAdministrador(int id) {
        repository.deleteById(id);
    }

    public boolean existeAdministrador(int id) {
        return repository.existsById(id);
    }

    public void atualizarAdministrador(Administrador administrador) {
        repository.save(administrador);
    }
}
