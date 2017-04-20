package br.edu.ifrs.canoas.lds.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.domain.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{//objeto dominio de referencia e tipo de chave(id)

}
