package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private User user;

	private String cidade;
	private String uf;
	private String endereco;
	private int numero;

	public Endereco() {
	}

	public Endereco(Long id, User user, String cidade, String uf, String endereco, int numero) {

		this.id = id;
		this.user = user;
		this.cidade = cidade;
		this.uf = uf;
		this.endereco = endereco;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
