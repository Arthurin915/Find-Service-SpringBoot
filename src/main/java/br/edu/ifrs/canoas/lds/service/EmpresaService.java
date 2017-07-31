package br.edu.ifrs.canoas.lds.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.domain.Empresa;
import br.edu.ifrs.canoas.lds.repository.EmpresaRepository;
@Service
public class EmpresaService {
	
	private final EmpresaRepository empresaRepository;
	private final PasswordEncoder passwordEncoder;

	public EmpresaService(EmpresaRepository empresaRepository, PasswordEncoder passwordEncoder) {
		this.empresaRepository=empresaRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public Iterable<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	public Empresa findByEmail(Empresa empresa) {
		return empresaRepository.findByEmail(empresa.getEmail());
	}
	public Empresa getSession(SecurityContext context) {
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				Empresa empresa = new Empresa();

				empresa.setEmail(authentication.getName());

				// Carrega usuário a partir do email obtido
				empresa = this.findByEmail(empresa);

				// Carrega todos os outros atributos do usuário, a partir do
				// usuário atual
				return empresa;
			}
		}
		return null;
	}

	public PasswordEncoder getEncoder() {
		return this.passwordEncoder;
	}
	public List<Empresa> pesquisa(String nome) {
		return empresaRepository.findAllByNomeContainingIgnoreCase(nome);
	}
}
