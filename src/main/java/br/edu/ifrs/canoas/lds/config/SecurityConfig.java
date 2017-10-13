package br.edu.ifrs.canoas.lds.config;

import br.edu.ifrs.canoas.lds.service.UserDetailsImplService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * Created by rodrigo on 2/22/17.
 */
@Configuration
@EnableGlobalAuthentication
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {

	private final UserDetailsImplService userDetailsService;

	public SecurityConfig(UserDetailsImplService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
	}
	
	

}
