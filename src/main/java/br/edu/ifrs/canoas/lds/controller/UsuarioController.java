package br.edu.ifrs.canoas.lds.controller;


import java.util.List;

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

import br.edu.ifrs.canoas.lds.domain.Empresa;
import br.edu.ifrs.canoas.lds.domain.Usuario;
import br.edu.ifrs.canoas.lds.service.EmpresaService;
import br.edu.ifrs.canoas.lds.service.UsuarioService;

@Controller
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final EmpresaService empresaService;
	private final PasswordEncoder passwordEncoder;

	public UsuarioController(UsuarioService usuarioService,EmpresaService empresaService,
 PasswordEncoder passwordEncoder) {
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
		this.empresaService=empresaService;
	}

	@GetMapping("/login")
	public String index(Model model) {
		SecurityContext context = SecurityContextHolder.getContext();
		model.addAttribute("usuarios", usuarioService.findAll());
		model.addAttribute("empresas", empresaService.findAll());
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("empresa", new Empresa());
		model.addAttribute("usuarioLogado", usuarioService.getSession(context));

		return "index";
	}

	@PostMapping("/save")
	public String save(Model model, @Valid Usuario usuario, @Valid Empresa empresa, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println("tem erro");
		}
		// criptografa senha do usuário
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		empresa.setSenha(passwordEncoder.encode(empresa.getSenha()));
		// salva usuário no BD
		usuarioService.save(usuario);
		empresaService.save(empresa);
		// Retorna para página inicial
		return "redirect:/login";
	}
	@GetMapping("/empresa/{nome}")
	@ResponseBody()
	public List<Empresa> pesquisa(@PathVariable String nome) {
		return empresaService.pesquisa(nome);
	}
}
