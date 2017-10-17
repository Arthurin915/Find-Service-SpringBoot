package br.edu.ifrs.canoas.lds.repository;

import br.edu.ifrs.canoas.lds.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by rodrigo on 2/21/17.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}