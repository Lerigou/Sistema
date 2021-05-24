package br.com.sistema.service;

import br.com.sistema.model.Projeto;
import br.com.sistema.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService{

    @Autowired
    ProjetoRepository projetoRepository;

    @Override
    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    @Override
    public Projeto findById(Long id) {
        return projetoRepository.findById(id).get();
    }

    @Override
    public boolean save(Projeto projeto) {
        try{
            projetoRepository.save(projeto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try{
            projetoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println("Erro ao deletar. " + e.getMessage());
            return false;
        }
    }
}
