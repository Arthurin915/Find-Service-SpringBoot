package br.edu.ifrs.canoas.lds.repository;
  
 import br.edu.ifrs.canoas.lds.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
 
 
  @Repository
  public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
      Pessoa findByEmail(String email);
      List<Pessoa> findAllByNomeContainingIgnoreCase(String nome);
  }