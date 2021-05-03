package br.com.sistema.controller;

import br.com.sistema.model.Funcionario;
import br.com.sistema.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/funcionario/save")
    public String save(Funcionario funcionario , Model model){
        System.out.println(funcionario);

        if (funcionarioService.findByEmail(funcionario.getEmail()) != null) {

            model.addAttribute("funcionario", funcionario);
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", "O email já existe no banco, insira outro!");
            return "funcionario/add";
        }

        if (funcionarioService.save(funcionario)){
            return "redirect:/funcionario/list";
        } else {
            model.addAttribute("funcionario", funcionario);
            return "redirect:/funcionario/add";
        }
    }
}
