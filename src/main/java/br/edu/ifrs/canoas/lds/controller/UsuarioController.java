package br.edu.ifrs.canoas.lds.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifrs.canoas.lds.domain.Usuario;
import br.edu.ifrs.canoas.lds.service.UsuarioService;

@Controller
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder; 
	
	public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/login")
	public String index(Model model){
		SecurityContext context = SecurityContextHolder.getContext();
		model.addAttribute("usuarios", usuarioService.findAll());
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("usuarioLogado",usuarioService.getSession(context));
		return "index";
	}
	@PostMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}

	@PostMapping("/save")
	public String save(Model model, @Valid Usuario usuario){
		
		//criptografa senha do usuário
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		
		//salva usuário no BD
		usuarioService.save(usuario);
		
		//Retorna para página inicial
		return "redirect:/login";
	}
}
