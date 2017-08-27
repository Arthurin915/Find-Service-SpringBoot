package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{

    private Integer cnpj;

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }
}
