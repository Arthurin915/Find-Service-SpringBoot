package br.edu.ifrs.canoas.lds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.domain.Pessoa;
import br.edu.ifrs.canoas.lds.domain.Telefone;
import br.edu.ifrs.canoas.lds.repository.TelefoneRepository;

@Service
public class TelefoneService {
	private final TelefoneRepository telefoneRepository;

	public TelefoneService(TelefoneRepository telefoneRepository) {
		this.telefoneRepository = telefoneRepository;
	}
	public Iterable<Telefone> findAll() {
 		return telefoneRepository.findAll();
 	}
	
	public List<Telefone> telefonesPessoa(Pessoa pessoa){
		return this.telefoneRepository.findAllByPessoa(pessoa);
	}
	
}
