package br.com.sistema.service;

import br.com.sistema.model.Cargo;
import br.com.sistema.model.Funcionario;
import br.com.sistema.repository.FuncionarioRepository;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> findAll();
    public Funcionario findById(Long id);
    public Funcionario findByEmail(String email);
    public String validarFuncionario(Funcionario funcionario);
    public List<Funcionario> findByCargo(Cargo cargo);
    public boolean save(Funcionario funcionario);
    public boolean deleteById(Long id);
}

