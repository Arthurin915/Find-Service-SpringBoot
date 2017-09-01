package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance
@DiscriminatorColumn(name = "TIPO_PESSOA")
public abstract class Pessoa {

    @Id @GeneratedValue
    private Long id;
  	private String cep;
    private String nome;
    @Column(unique=true)
    private String email;
    @OneToMany
    private List<Telefone> telefones;
    @OneToMany
    private List<Endereco> enderecos;
 	private String senha;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
