package br.com.sistema.service;

import br.com.sistema.model.Cargo;
import br.com.sistema.model.Funcionario;
import br.com.sistema.repository.CargoRepository;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    CargoRepository cargoRepository;

    @Override
    public Cargo findById(Long id) {
        return cargoRepository.findById(id).get();
    }

    @Override
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo findByNome(String nome) {
        return cargoRepository.findByNome(nome);
    }

    @Override
    public boolean save(Cargo cargo) {
        try{
            if(cargo != null){
                cargoRepository.save(cargo);
                return true;
            }else {
                return false;
            }
        } catch (Exception e){
            System.out.println("Erro ao salvar o cargo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String deleteById() {
        return null;
    }

    @Override
    public String validarCargo(Cargo cargo) {
        String error = null;
        Cargo c;

        if (cargo.getId() == null) {//novo cargo
            c = cargoRepository.findByNome(cargo.getNome());
            if (c != null) {
                error = "Nome já cadastrado!";

            }
        } else {//cargo existente
            c = cargoRepository.findByIdNotAndNome(cargo.getId(), cargo.getNome());
            if (c != null) {
                error = "Nome já cadastrado!";
            }
        }
        return error;
    }

    @Override
    public boolean deleteById(Long id){
        try {
            if (id != null || id > 0){
                cargoRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            System.out.println("erro ao deletar o cargo. " + e.getMessage());
            return false;
        }
    }
}