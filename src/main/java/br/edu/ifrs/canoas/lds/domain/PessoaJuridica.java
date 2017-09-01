package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{

 	private String categoria;

    private Integer cnpj;

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
