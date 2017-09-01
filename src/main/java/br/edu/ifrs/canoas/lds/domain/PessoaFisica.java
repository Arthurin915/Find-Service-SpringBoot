package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa{


    private Integer cpf;

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }
}
