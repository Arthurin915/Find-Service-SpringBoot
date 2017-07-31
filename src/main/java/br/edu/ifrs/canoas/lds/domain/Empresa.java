package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Empresa")
public class Empresa extends Usuario{

	private String categoria;
	private String horarioAbertura;
	private String horarioFechamento;
	private String horarioIntervalo;
	private String cnpj;
	
	public Empresa(){}
	
	public Empresa(Long id, String nome, String cep, String email, String cidade, String uf, String endereco,
			int numero, String senha, String telefone, String confirmar, String categoria, String horarioAbertura, String horarioFechamento, String horarioIntervalo,
			String cnpj) {
		super(id,nome,cep,email,cidade,uf,endereco,numero,senha,telefone,confirmar);
		this.categoria = categoria;
		this.horarioAbertura = horarioAbertura;
		this.horarioFechamento = horarioFechamento;
		this.horarioIntervalo = horarioIntervalo;
		this.cnpj = cnpj;
	}
	public String getHorarioAbertura() {
		return horarioAbertura;
	}
	public void setHorarioAbertura(String horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}
	public String getHorarioFechamento() {
		return horarioFechamento;
	}
	public void setHorarioFechamento(String horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}
	public String getHorarioIntervalo() {
		return horarioIntervalo;
	}
	public void setHorarioIntervalo(String horarioIntervalo) {
		this.horarioIntervalo = horarioIntervalo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
