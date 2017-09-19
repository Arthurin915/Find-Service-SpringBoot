 package br.edu.ifrs.canoas.lds.service;
  
 import br.edu.ifrs.canoas.lds.domain.Pessoa;
import br.edu.ifrs.canoas.lds.domain.PessoaFisica;
import br.edu.ifrs.canoas.lds.domain.PessoaJuridica;
import br.edu.ifrs.canoas.lds.repository.PessoaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
 public class PessoaService {
 
 	private final PessoaRepository pessoaRepository;
 	private final PasswordEncoder passwordEncoder;
 
 	public PessoaService(PessoaRepository pessoaRepository, PasswordEncoder passwordEncoder) {
 		this.pessoaRepository = pessoaRepository;
 		this.passwordEncoder = passwordEncoder;
 	}
 
 	public Pessoa save(Pessoa pessoa) {
 		return pessoaRepository.save(pessoa);
 	}
 
 	public Iterable<Pessoa> findAll() {
 		return pessoaRepository.findAll();
 	}
 
 	public Pessoa findByEmail(Pessoa pessoa) {
  		return pessoaRepository.findByEmail(pessoa.getEmail());
  	}
  
 	public List<Pessoa> pesquisa(String nome) {
		return pessoaRepository.findAllByNomeContainingIgnoreCase(nome);
  	}
  
 	public Pessoa getSessionJ(SecurityContext context) {
 		if (context instanceof SecurityContext) {
 			Authentication authentication = context.getAuthentication();
 			if (authentication instanceof Authentication) {
 				Pessoa pessoa = new PessoaJuridica();
 
 				pessoa.setEmail(authentication.getName());
 
 				// Carrega usuário a partir do email obtido
 				pessoa = this.findByEmail(pessoa);
 
 				// Carrega todos os outros atributos do usuário, a partir do
 				// usuário atual
 				return pessoa;
 			}
 		}
 		return null;
 	}
 	public Pessoa getSessionF(SecurityContext context) {
 		if (context instanceof SecurityContext) {
 			Authentication authentication = context.getAuthentication();
 			if (authentication instanceof Authentication) {
 				Pessoa pessoa = new PessoaFisica();
 
 				pessoa.setEmail(authentication.getName());
 
 				// Carrega usuário a partir do email obtido
 				pessoa = this.findByEmail(pessoa);
 
 				// Carrega todos os outros atributos do usuário, a partir do
 				// usuário atual
 				return pessoa;
 			}
 		}
 		return null;
 	}
 
 	public PasswordEncoder getEncoder() {
 		return this.passwordEncoder;
 	}
 }