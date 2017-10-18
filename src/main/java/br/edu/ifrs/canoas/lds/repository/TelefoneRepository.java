package br.edu.ifrs.canoas.lds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.domain.Telefone;
import br.edu.ifrs.canoas.lds.domain.User;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	List<Telefone> findAllByUser(User user);

}
