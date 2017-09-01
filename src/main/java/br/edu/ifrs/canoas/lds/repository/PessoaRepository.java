package br.edu.ifrs.canoas.lds.repository;
  
 import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.domain.Pessoa;
 
 
  @Repository
  public interface PessoaRepository extends JpaRepository<Pessoa, Long>{//objeto dominio de referencia e tipo de chave(id)
	  Pessoa findByEmail(String email);
 	List<Pessoa> findAllByNomeContainingIgnoreCase(String nome);
  }