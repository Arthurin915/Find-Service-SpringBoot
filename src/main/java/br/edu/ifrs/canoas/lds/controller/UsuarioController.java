package br.edu.ifrs.canoas.lds.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifrs.canoas.lds.domain.Usuario;
import br.edu.ifrs.canoas.lds.service.UsuarioService;

@Controller
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	@GetMapping("/")
	public String index(Model model){ 
		model.addAttribute("usuarios", usuarioService.findAll());
		model.addAttribute("usuario", new Usuario());
		return "index";
	}

	@PostMapping("/save")
	public String save(Model model, @Valid Usuario usuario){
		Usuario newUser = usuarioService.save(usuario);
		return "redirect:/";
	}
}
