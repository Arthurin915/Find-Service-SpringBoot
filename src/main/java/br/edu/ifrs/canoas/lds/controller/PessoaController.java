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
 
 	public PessoaController(PessoaService pessoaService, EnderecoService enderecoService, TelefoneService telefoneService) {
 		this.pessoaService = pessoaService;
 		this.enderecoService=enderecoService;
 		this.telefoneService=telefoneService;
 	}
 
 	 
 	@GetMapping("/")
 	public String index(Model model, @AuthenticationPrincipal UserImpl activeUser) {
 		
 		if (activeUser != null) {
 			User user = pessoaService.findById(activeUser.getUser().getId()).get();
 	 		model.addAttribute("role", user.getRole());
 	 		model.addAttribute("nome", user.getNome()); 
   	 		model.addAttribute("pessoa", user);
   	 		model.addAttribute("pessoafisica", user);
 		}
 		
 		
 		model.addAttribute("pessoaJ", new PessoaJuridica());
 		model.addAttribute("pessoaF", new PessoaFisica());

 	 		
 		return "index";
 	}
 
 	@PostMapping("/saveF")
 	public String saveF(Model model, @Valid PessoaFisica pessoaFisica, BindingResult result, RedirectAttributes attributes) {
 		
 		// salva usuÃ¡rio no BD
 		pessoaFisica.getEnderecos().set(0,enderecoService.save(pessoaFisica.getEnderecos().get(0)));
 		pessoaFisica.getTelefones().set(0,telefoneService.save(pessoaFisica.getTelefones().get(0)));
 		pessoaService.save(pessoaFisica);

 		// Retorna para pÃ¡gina inicial
 		return "redirect:/";
 	}
 	@PostMapping("/saveJ")
 	public String saveJ(Model model, @Valid PessoaJuridica pessoaJuridica, BindingResult result, RedirectAttributes attributes) {

 		// salva usuÃ¡rio no BD
 		pessoaJuridica.getEnderecos().set(0,enderecoService.save(pessoaJuridica.getEnderecos().get(0)));
 		pessoaJuridica.getTelefones().set(0,telefoneService.save(pessoaJuridica.getTelefones().get(0)));
 		pessoaService.save(pessoaJuridica);

 		// Retorna para pÃ¡gina inicial
 		return "redirect:/";
 	}
  
  	@GetMapping("/pessoa/{nome}")
  	@ResponseBody()
  	public List<User> pesquisa(@PathVariable String nome) {
  		return pessoaService.pessoasJuridicas(nome);
  	}
  	
  	@PostMapping("/busca/{categoria}")
  	@ResponseBody
  	public List<PessoaJuridica> buscaEmpresas(){
  }
}