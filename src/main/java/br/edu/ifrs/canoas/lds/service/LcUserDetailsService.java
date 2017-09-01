package br.edu.ifrs.canoas.lds.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.ifrs.canoas.lds.domain.Pessoa;
import br.edu.ifrs.canoas.lds.repository.PessoaRepository;

public class LcUserDetailsService implements UserDetailsService{
	private PessoaRepository pessoaRepository;
	
	public LcUserDetailsService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Pessoa pessoa = pessoaRepository.findByEmail(username);
		if(pessoa == null){
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return new User(pessoa.getEmail(), pessoa.getSenha(), getAuthorities(pessoa));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Pessoa pessoa) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return grantedAuthorities;
    }

	

}
