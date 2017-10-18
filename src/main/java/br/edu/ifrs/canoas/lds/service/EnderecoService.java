package br.edu.ifrs.canoas.lds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.domain.Endereco;
import br.edu.ifrs.canoas.lds.domain.User;
import br.edu.ifrs.canoas.lds.repository.EnderecoRepostiroy;

@Service
public class EnderecoService {
	private final EnderecoRepostiroy enderecoRepository;

	public EnderecoService(EnderecoRepostiroy enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public Endereco save(Endereco endereco){
		return enderecoRepository.save(endereco);
	}
	
	public Iterable<Endereco> findAll() {
 		return enderecoRepository.findAll();
 	}
	
	public List<Endereco> enderecosPessoa (User user){
		return this.enderecoRepository.findAllByUser(user);
	}
	
}
