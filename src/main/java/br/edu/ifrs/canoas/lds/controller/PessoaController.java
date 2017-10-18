package br.edu.ifrs.canoas.lds.controller;

import br.edu.ifrs.canoas.lds.config.UserImpl;
import br.edu.ifrs.canoas.lds.domain.*;
import br.edu.ifrs.canoas.lds.service.EnderecoService;
import br.edu.ifrs.canoas.lds.service.PessoaService;
import br.edu.ifrs.canoas.lds.service.TelefoneService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
 
 @Controller
 public class PessoaController {
 
 	private final PessoaService pessoaService;
 	private final EnderecoService enderecoService;
 	private final TelefoneService telefoneService;
// 	private final PasswordEncoder passwordEncoder;
 
 	public PessoaController(PessoaService pessoaService, EnderecoService enderecoService, TelefoneService telefoneService
//            , PasswordEncoder passwordEncoder
    ) {
 		this.pessoaService = pessoaService;
 		this.enderecoService=enderecoService;
 		this.telefoneService=telefoneService;
// 		this.passwordEncoder = passwordEncoder;
 	}
 
 	
 	@GetMapping("/")
 	public String index(Model model, @AuthenticationPrincipal UserImpl activeUser) {
 		
 		if (activeUser != null) {
 	 		model.addAttribute("role", activeUser.getUser().getRole());
 	 		model.addAttribute("nome", activeUser.getUser().getNome()); 	 		
 		}
 		
 		model.addAttribute("users", pessoaService.findAll());
 		model.addAttribute("pessoaJ", new PessoaJuridica());
 		model.addAttribute("pessoaF", new PessoaFisica());

 		//model.addAttribute("pessoaF_logada", pessoaService.getSessionF(context));
 		//model.addAttribute("pessoaJ_logada", pessoaService.getSessionJ(context));
 		
 		return "index";
 	}
 
 	@PostMapping("/saveF")
 	public String saveF(Model model, @Valid PessoaFisica pessoaFisica, @Valid Endereco endereco, @Valid Telefone telefone, BindingResult result, RedirectAttributes attributes) {
 		enderecoService.save(endereco);
 		telefoneService.save(telefone);
 	

 		// salva usuário no BD
 		pessoaService.save(pessoaFisica);

 		// Retorna para página inicial
 		return "redirect:/";
 	}
 	@PostMapping("/saveJ")
 	public String saveJ(Model model, @Valid PessoaJuridica pessoaJuridica, @Valid Endereco endereco, @Valid Telefone telefone, BindingResult result, RedirectAttributes attributes) {

 		enderecoService.save(endereco);
 		telefoneService.save(telefone);

 		// salva usuário no BD
 		pessoaService.save(pessoaJuridica);

 		// Retorna para página inicial
 		return "redirect:/";
 	}
  
  	@GetMapping("/pessoa/{nome}")
  	@ResponseBody()
  	public List<User> pesquisa(@PathVariable String nome) {
  		return pessoaService.pessoasJuridicas(nome);
  	}
  	
  }
