package br.com.springmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springmongodb.domain.model.Funcionario;
import br.com.springmongodb.domain.service.FuncionarioService;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

      @Autowired
      private FuncionarioService funcionarioService;

      @GetMapping
      public List<Funcionario> obterTodos() {
            return funcionarioService.obterTodos();
      }

      @GetMapping("{codigo}")
      public Funcionario obterPorCodigo(@PathVariable String codigo) {
            return funcionarioService.obterPorCodigo(codigo);
      }

      @PostMapping
      @ResponseStatus(HttpStatus.CREATED)
      public Funcionario criar(@RequestBody Funcionario funcionario) {
            return funcionarioService.criar(funcionario);
      }

      @GetMapping("range")
      public List<Funcionario> obterFuncionariosPorRangeDeIdade(@RequestParam("de") Integer de, @RequestParam("ate") Integer ate) {
            return funcionarioService.obterFuncionariosPorRangeDeIdade(de, ate);
      }
      
      @GetMapping("por-nome")
      public List<Funcionario> obterFuncionariosPorNome(@RequestParam("nome") String nome) {
            return funcionarioService.obterFuncionariosPorNome(nome);
      }
}