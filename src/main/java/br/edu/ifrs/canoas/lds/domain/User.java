package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rodrigo on 2/21/17.
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "TIPO_USER")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
    private boolean active;
    private String cep;
    private String nome;
    @Column(unique=true)
    private String email;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Telefone> telefones;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Endereco> enderecos;

    public User() {
        enderecos = new ArrayList<>();
        enderecos.add(new Endereco());
        telefones = new ArrayList<>();
        telefones.add(new Telefone());
        roles = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Transient
    public String getRole() {
        return !roles.isEmpty() ? roles.iterator().next().getRole() : null;
    }
}