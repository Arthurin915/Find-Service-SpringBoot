package br.edu.ifrs.canoas.lds.domain;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String cep, String nome, String email, List<Telefone> telefones, List<Endereco> enderecos,
			String senha, Integer cpf) {
		super(cep, nome, email, telefones, enderecos, senha);
		this.cpf = cpf;
	}

	private Integer cpf;

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
}
