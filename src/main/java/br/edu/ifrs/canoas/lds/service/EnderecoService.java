package br.edu.ifrs.canoas.lds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.domain.Endereco;
import br.edu.ifrs.canoas.lds.domain.Pessoa;
import br.edu.ifrs.canoas.lds.repository.EnderecoRepostiroy;

@Service
public class EnderecoService {
	private final EnderecoRepostiroy enderecoRepository;

	public EnderecoService(EnderecoRepostiroy enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public Iterable<Endereco> findAll() {
 		return enderecoRepository.findAll();
 	}
	
	public List<Endereco> enderecosPessoa (Pessoa pessoa){
		return this.enderecoRepository.findAllByPessoa(pessoa);
	}
	
}
