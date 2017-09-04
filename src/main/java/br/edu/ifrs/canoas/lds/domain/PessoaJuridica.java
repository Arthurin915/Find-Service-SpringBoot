package br.edu.ifrs.canoas.lds.domain;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{

 	private String categoria;

    private Integer cnpj;
    
    public PessoaJuridica(){
    	super();
    }
    public PessoaJuridica(String cep,String nome,String email,List<Telefone> telefones,List<Endereco> enderecos,String senha, String categoria, Integer cnpj) {
		super(cep,nome,email,telefones,enderecos,senha);
		this.categoria = categoria;
		this.cnpj = cnpj;
	}

	public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
