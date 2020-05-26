package br.com.springmongodb.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springmongodb.domain.model.Funcionario;
import br.com.springmongodb.domain.repository.FuncionarioRepository;
import br.com.springmongodb.domain.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

      @Autowired
      private FuncionarioRepository funcionarioRepository;

      @Override
      public List<Funcionario> obterTodos() {
            return funcionarioRepository.findAll();
      }

      @Override
      public Funcionario obterPorCodigo(String codigo) {
            return funcionarioRepository.findById(codigo)
                  .orElseThrow(() -> new IllegalArgumentException("Funcionário não localizado."));
      }

      @Override
      public Funcionario criar(Funcionario funcionario) {
            var chefe = obterPorCodigo(funcionario.getChefe().getCodigo());

            funcionario.setChefe(chefe);

            return funcionarioRepository.save(funcionario);
      }

      @Override
      public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate) {
            return funcionarioRepository.obterFuncionariosPorRangeDeIdade(de, ate);
      }

      @Override
      public List<Funcionario> obterFuncionariosPorNome(String nome) {
            return funcionarioRepository.findByNome(nome);
      }
      
}