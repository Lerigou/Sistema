package br.com.sistema.repository;

import br.com.sistema.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    public Cargo findByNome(String nome);

}
