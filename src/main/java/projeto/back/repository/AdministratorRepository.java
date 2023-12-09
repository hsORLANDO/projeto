package projeto.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import projeto.back.model.Administrador;

public interface AdministratorRepository extends CrudRepository<Administrador, Integer> {

@Query(value="select CASE WHEN cout(1) > 0 THEN 'true' ELSE 'false' END from administradores where id = :id", nativeQuery = true)
public boolean exist(int id);

@Query(value="select * from administradores where email = :email and senha = :senha", nativeQuery = true)
public Administrador Login(String email, String senha);

Optional<Administrador> findByEmail(String email);
}
