package br.edu.ifrs.canoas.lds.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.ifrs.canoas.lds.repository.UsuarioRepository;
import br.edu.ifrs.canoas.lds.service.LcUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UsuarioRepository usuarioRepository;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers("/save","/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.usernameParameter("email")
			.passwordParameter("senha")
			.defaultSuccessUrl("/login")
			.failureUrl("/login?erro")
			.and()
			.sessionManagement()	
	        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	        .and()
	        .logout()
	        .logoutSuccessUrl("/login?logoutSuccess")
	        .permitAll();	
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**","/webjars/**", "/font-awesome/**", "/fonts/**", "/images/**", "/db/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new LcUserDetailsService(usuarioRepository);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
