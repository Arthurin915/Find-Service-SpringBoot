package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends User {

    private Integer cpf;


	public PessoaFisica() {
		super();
	}


	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
}
