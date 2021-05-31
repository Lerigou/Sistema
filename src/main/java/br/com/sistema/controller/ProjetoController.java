package br.com.sistema.controller;

import br.com.sistema.model.Cargo;
import br.com.sistema.model.Projeto;
import br.com.sistema.service.CargoServiceImpl;
import br.com.sistema.service.FuncionarioService;
import br.com.sistema.service.FuncionarioServiceImpl;
import br.com.sistema.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class ProjetoController {

    @Autowired
    ProjetoServiceImpl projetoService;

    @Autowired
    CargoServiceImpl cargoService;

    @Autowired
    FuncionarioServiceImpl FuncionarioService;

    @GetMapping("/projeto/list")
    public String list(Model model){
        model.addAttribute("projetos", projetoService.findAll());
        return "projeto/list";
    }

    @GetMapping("/projeto/add")
    public String add(Model model){
        model.addAttribute("projeto", new Projeto());
        Cargo cargo = cargoService.findByNome("Gerente");
        model.addAttribute("gerentes", FuncionarioService.findByCargo(cargo));
        return "projeto/add";
    }

    @PostMapping("/projeto/save")
    public String save(Projeto projeto, Model model){

        //precisa fazer o validar

        if (projetoService.save(projeto)){
            return "redirect:/projeto/list";
        }else {
            return "redirect:/projeto/list";
        }
    }

    @GetMapping("/projeto/delete/{id}")
    public String delete(@PathVariable Long id){
        projetoService.deleteById(id);
        return "projeto/list";
    }
}
