package br.edu.ifrs.canoas.lds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	List<Empresa> findAllByNomeContainingIgnoreCase(String nome);
	Empresa findByEmail(String email);

}
