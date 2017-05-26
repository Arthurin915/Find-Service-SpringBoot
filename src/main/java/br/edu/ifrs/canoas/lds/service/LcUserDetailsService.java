package br.edu.ifrs.canoas.lds.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.ifrs.canoas.lds.domain.Usuario;
import br.edu.ifrs.canoas.lds.repository.UsuarioRepository;

public class LcUserDetailsService implements UserDetailsService{
	private UsuarioRepository usuarioRepository;
	
	public LcUserDetailsService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return new User(user.getEmail(), user.getSenha(), getAuthorities(user));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return grantedAuthorities;
    }

	

}