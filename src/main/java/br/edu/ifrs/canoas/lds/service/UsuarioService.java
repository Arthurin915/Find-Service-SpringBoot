package br.edu.ifrs.canoas.lds.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.domain.Usuario;
import br.edu.ifrs.canoas.lds.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findByEmail(Usuario usuario) {
		return usuarioRepository.findByEmail(usuario.getEmail());
	}

	public List<Usuario> pesquisa(String nome) {
		return usuarioRepository.findAllByNomeContainingIgnoreCase(nome);
	}

	public Usuario getSession(SecurityContext context) {
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				Usuario usuario = new Usuario();

				usuario.setEmail(authentication.getName());

				// Carrega usuário a partir do email obtido
				usuario = this.findByEmail(usuario);

				// Carrega todos os outros atributos do usuário, a partir do
				// usuário atual
				return usuario;
			}
		}
		return null;
	}

	public PasswordEncoder getEncoder() {
		return this.passwordEncoder;
	}
}
