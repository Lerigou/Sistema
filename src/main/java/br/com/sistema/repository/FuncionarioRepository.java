package br.com.sistema.repository;

import br.com.sistema.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    //Vai dizer se já existe ou n no banco de dados
    public Funcionario findByEmail(String email);
    public Funcionario findByNome(String nome);
    public Funcionario findByTelefone(String telefone);

}
