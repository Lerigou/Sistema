package br.com.sistema.controller;

import br.com.sistema.model.Funcionario;
import br.com.sistema.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @GetMapping("/funcionario/list")
    public String list(Model model){
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "funcionario/list";
    }

    @GetMapping("/funcionario/add")
    public String add(Model model){
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/add";
    }
}
