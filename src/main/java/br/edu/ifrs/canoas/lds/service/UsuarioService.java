package br.edu.ifrs.canoas.lds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.domain.Usuario;
import br.edu.ifrs.canoas.lds.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
}
