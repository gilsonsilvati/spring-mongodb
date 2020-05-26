package br.com.springmongodb.domain.service;

import java.util.List;

import br.com.springmongodb.domain.model.Funcionario;

public interface FuncionarioService {
      
      public List<Funcionario> obterTodos();

      public Funcionario obterPorCodigo(String codigo);

      public Funcionario criar(Funcionario funcionario);

      public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate);

      public List<Funcionario> obterFuncionariosPorNome(String nome);

}