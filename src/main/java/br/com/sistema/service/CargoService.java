package br.com.sistema.service;

import br.com.sistema.model.Cargo;

import java.util.List;

public interface CargoService {

    public Cargo findById(Long id);
    public Cargo findByNome(String nome);
    public List<Cargo> findAll();
    public String validarCargo(Cargo cargo);

    public boolean save(Cargo cargo);
    public String deleteById();

    boolean deleteById(Long id);
}
