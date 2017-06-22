package br.edu.ifrs.canoas.lds.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.domain.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{//objeto dominio de referencia e tipo de chave(id)
	Usuario findByEmail(String email);
	Usuario findById(Long Id);
}
