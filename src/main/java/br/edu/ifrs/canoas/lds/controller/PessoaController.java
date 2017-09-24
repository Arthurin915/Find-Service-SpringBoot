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
import br.edu.ifrs.canoas.lds.service.EnderecoService;
import br.edu.ifrs.canoas.lds.service.PessoaService;
import br.edu.ifrs.canoas.lds.service.TelefoneService;
 
 @Controller
 public class PessoaController {
 
 	private final PessoaService pessoaService;
 	private final EnderecoService enderecoService;
 	private final TelefoneService telefoneService;
 	private final PasswordEncoder passwordEncoder;
 
 	public PessoaController(PessoaService pessoaService, EnderecoService enderecoService, TelefoneService telefoneService, PasswordEncoder passwordEncoder) {
 		this.pessoaService = pessoaService;
 		this.enderecoService=enderecoService;
 		this.telefoneService=telefoneService;
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
 		
 		return "index";
 	}
 
 	@PostMapping("/saveF")
 	public String saveF(Model model, @Valid PessoaFisica pessoaFisica, @Valid Endereco endereco, @Valid Telefone telefone, BindingResult result, RedirectAttributes attributes) {
 		enderecoService.save(endereco);
 		telefoneService.save(telefone);
 		// criptografa senha do usuário
 		pessoaFisica.setSenha(passwordEncoder.encode(pessoaFisica.getSenha()));

 		// salva usuário no BD
 		pessoaService.save(pessoaFisica);

 		// Retorna para página inicial
 		return "redirect:/login";
 	}
 	@PostMapping("/saveJ")
 	public String saveJ(Model model, @Valid PessoaJuridica pessoaJuridica, @Valid Endereco endereco, @Valid Telefone telefone, BindingResult result, RedirectAttributes attributes) {

 		enderecoService.save(endereco);
 		telefoneService.save(telefone);
 		// criptografa senha do usuário
 		pessoaJuridica.setSenha(passwordEncoder.encode(pessoaJuridica.getSenha()));

 		// salva usuário no BD
 		pessoaService.save(pessoaJuridica);

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
