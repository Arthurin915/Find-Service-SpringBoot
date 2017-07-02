package br.edu.ifrs.canoas.lds.controller;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@PostMapping("/save")
	public String save(Model model, @Valid Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			System.out.println("tem erro");
		}
		//criptografa senha do usuário
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		//salva usuário no BD
		usuarioService.save(usuario);
		
		//Retorna para página inicial
		return "redirect:/login";
	}
	
	
}
