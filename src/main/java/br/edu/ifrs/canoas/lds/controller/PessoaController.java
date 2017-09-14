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

import br.edu.ifrs.canoas.lds.domain.Endereco;
import br.edu.ifrs.canoas.lds.domain.Pessoa;
import br.edu.ifrs.canoas.lds.domain.PessoaFisica;
import br.edu.ifrs.canoas.lds.domain.PessoaJuridica;
import br.edu.ifrs.canoas.lds.domain.Telefone;
import br.edu.ifrs.canoas.lds.service.PessoaService;
 
 @Controller
 public class PessoaController {
 
 	private final PessoaService pessoaService;
 	private final PasswordEncoder passwordEncoder;
 
 	public PessoaController(PessoaService pessoaService, PasswordEncoder passwordEncoder) {
 		this.pessoaService = pessoaService;
 		this.passwordEncoder = passwordEncoder;
 	}
 
 	@GetMapping("/editar")
 	public String editar(Model model) {
 		return "Editar";
 	}
 	@GetMapping("/login")
 	public String index(Model model) {
 		SecurityContext context = SecurityContextHolder.getContext();
 		model.addAttribute("pessoas", pessoaService.findAll());
 		model.addAttribute("pessoaJ", new PessoaJuridica());
 		model.addAttribute("pessoaF", new PessoaFisica());

 		model.addAttribute("pessoaF_logada", pessoaService.getSessionF(context));
 		model.addAttribute("pessoaJ_logada", pessoaService.getSessionJ(context));
 		
 		System.out.println("entrou");
 		return "index";
 	}
 
 	@PostMapping("/save")
 	public String save(Model model, @Valid Pessoa pessoa, BindingResult result, RedirectAttributes attributes) {
 		
 		// criptografa senha do usuário
 		pessoa.setSenha(passwordEncoder.encode(pessoa.getSenha()));
 		// salva usuário no BD
 		pessoaService.save(pessoa);
 
 		// Retorna para página inicial
 		return "redirect:/login";
 	}
 	@PostMapping("/saveEnderecos/{id}")
 	public String saveEnderecos(List<Endereco> enderecos, @PathVariable("id") Long id){
 		return "redirect:/login";
 	}
 	@PostMapping("/saveTelefones/{id}")
 	public String saveTelefones(List<Telefone> telefones, @PathVariable("id") Long id){
 		return "redirect:/login";
 	}
  
  	@GetMapping("/pessoa/{nome}")
  	@ResponseBody()
  	public List<Pessoa> pesquisa(@PathVariable String nome) {
  		return pessoaService.pesquisa(nome);
  	}
  	
  }
