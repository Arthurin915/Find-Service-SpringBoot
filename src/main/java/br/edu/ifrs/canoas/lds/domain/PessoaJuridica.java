package br.edu.ifrs.canoas.lds.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends User {

	private String categoria;

	private Long cnpj;
	private int nota;
	private String descricao;

	public PessoaJuridica() {
		super();
	} 

	public PessoaJuridica(Long id, String username, String password, Set<Role> roles, boolean active, String cep,
			String nome, String email, List<Telefone> telefones, List<Endereco> enderecos, String categoria, Long cnpj,
			int nota, String descricao) {
		super(id, username, password, roles, active, cep, nome, email, telefones, enderecos);
		this.cnpj = cnpj;
		this.categoria = categoria;
		this.nota = nota;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
