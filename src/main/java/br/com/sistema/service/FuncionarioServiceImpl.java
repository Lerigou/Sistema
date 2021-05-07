package br.com.sistema.service;

import br.com.sistema.model.Funcionario;
import br.com.sistema.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    @Override
    public Funcionario findByEmail(String email) {
        return funcionarioRepository.findByEmail(email);
    }

    @Override
    public boolean save(Funcionario funcionario) {

        try {
            if (funcionario != null) {
                funcionarioRepository.save(funcionario);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String validarFuncionario(Funcionario funcionario) {
        String error = null;

        if (funcionario.getId() == null) {//novo funcionario
            if (!funcionarioRepository.findByNome(funcionario.getNome()).equals("")) {
                error = "Nome já cadastrado!";
            }

            if (!funcionarioRepository.findByEmail(funcionario.getEmail()).equals("")) {
                error += "\nEmail já cadastrado!";
            }

        }else {//funcionario existente
                if (funcionarioRepository.findByIdNotAndEmail(funcionario.getId(), funcionario.getEmail()) != null){
                    error = "Email já cadastrado!";
                }

                if (funcionarioRepository.findByIdNotAndEmail(funcionario.getId(), funcionario.getNome()) != null){
                    error += "\nNome já cadastrado!";
                }
            }
        return error;
    }

    public boolean deleteById(Long id){
        try {
            funcionarioRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}