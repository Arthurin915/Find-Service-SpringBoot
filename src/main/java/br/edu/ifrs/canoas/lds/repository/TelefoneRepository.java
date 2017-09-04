package br.edu.ifrs.canoas.lds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.domain.Pessoa;
import br.edu.ifrs.canoas.lds.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	List<Telefone> findAllByPessoa(Pessoa pessoa);

}
