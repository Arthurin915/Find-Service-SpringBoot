package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends User {

    private Long cpf;


	public PessoaFisica() {
		super();
	}


	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
}
