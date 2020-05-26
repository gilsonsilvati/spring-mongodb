package br.com.springmongodb.domain.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@Document(collection = "funcionario")
public class Funcionario {

      @Id
      private String codigo;

      private String nome;
      private Integer idade;
      private BigDecimal salario;

      @DBRef
      private Funcionario chefe;

}