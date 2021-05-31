package br.com.sistema.repository;

import br.com.sistema.model.Cargo;
import br.com.sistema.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    //Vai procurar se já existe ou n no banco de dados
    public Funcionario findByEmail(String email);
    public Funcionario findByNome(String nome);
    public Funcionario findByIdNotAndEmail(Long id, String email);
    public Funcionario findByIdNotAndNome(Long id, String nome);

}
