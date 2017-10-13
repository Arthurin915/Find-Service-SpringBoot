package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by rodrigo on 2/21/17.
 */
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
	private String name;
	private String email;
    private boolean active;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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