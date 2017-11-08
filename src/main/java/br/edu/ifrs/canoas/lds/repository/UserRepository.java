package br.edu.ifrs.canoas.lds.repository;

import br.edu.ifrs.canoas.lds.domain.Endereco;
import br.edu.ifrs.canoas.lds.domain.PessoaJuridica;
import br.edu.ifrs.canoas.lds.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Created by rodrigo on 2/21/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    User findByEmail(String email);
    List<User> findAllByNomeContainingIgnoreCase(String nome);
	Optional<User> findByNome(String nome);
	List<User> findAllByEnderecos(List<Endereco> enderecos);

    List<PessoaJuridica> findAllByCategoria(String categoria);
}