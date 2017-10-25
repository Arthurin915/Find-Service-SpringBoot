package br.edu.ifrs.canoas.lds.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends User{

 	private String categoria;

    private Long cnpj;
    
    public PessoaJuridica(){
    	super();
    }

	public PessoaJuridica(Long id, String username, String password, Set<Role> roles, boolean active, String cep,
			String nome, String email, List<Telefone> telefones, List<Endereco> enderecos, String categoria, Long cnpj) {
		super(id, username, password, roles, active, cep, nome, email, telefones, enderecos);
		this.cnpj = cnpj;
		this.categoria = categoria;
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
