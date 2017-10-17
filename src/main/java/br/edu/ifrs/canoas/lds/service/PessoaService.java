 package br.edu.ifrs.canoas.lds.service;

 import br.edu.ifrs.canoas.lds.domain.PessoaFisica;
 import br.edu.ifrs.canoas.lds.domain.PessoaJuridica;
 import br.edu.ifrs.canoas.lds.domain.User;
 import br.edu.ifrs.canoas.lds.repository.RoleRepository;
 import br.edu.ifrs.canoas.lds.repository.UserRepository;
 import org.springframework.stereotype.Service;

 import java.util.List;

 @Service
 public class PessoaService {

     public PessoaService(UserRepository userRepository, RoleRepository roleRepository) {
         this.userRepository = userRepository;
         this.roleRepository = roleRepository;
     }

     private final UserRepository userRepository;
     private final RoleRepository roleRepository;
// 	private final PasswordEncoder passwordEncoder;


// 	public PessoaService(PessoaRepository pessoaRepository, PasswordEncoder passwordEncoder) {
// 		this.pessoaRepository = pessoaRepository;
// 		this.passwordEncoder = passwordEncoder;
// 	}
 	
 	public PessoaJuridica save(PessoaJuridica pessoaJuridica) {
 		return userRepository.save(pessoaJuridica);
 	}
 	public PessoaFisica save(PessoaFisica pessoaFisica) {
        pessoaFisica.setUsername(pessoaFisica.getEmail());
 	    pessoaFisica.getRoles().add(roleRepository.getOne(1L));
 		return userRepository.save(pessoaFisica);
 	}

 	public User save(User pessoa) {
 		return userRepository.save(pessoa);
 	}

 	public Iterable<User> findAll() {
 		return userRepository.findAll();
 	}

 	public User findByEmail(User user) {
  		return userRepository.findByEmail(user.getEmail());
  	}

 	public List<User> pesquisa(String nome) {
		return userRepository.findAllByNomeContainingIgnoreCase(nome);
  	}

	
  
// 	public Pessoa getSessionJ(SecurityContext context) {
// 		if (context instanceof SecurityContext) {
// 			Authentication authentication = context.getAuthentication();
// 			if (authentication instanceof Authentication) {
// 				Pessoa pessoa = new PessoaJuridica();
//
// 				pessoa.setEmail(authentication.getName());
//
// 				// Carrega usuário a partir do email obtido
// 				pessoa = this.findByEmail(pessoa);
//
// 				// Carrega todos os outros atributos do usuário, a partir do
// 				// usuário atual
// 				return pessoa;
// 			}
// 		}
// 		return null;
// 	}
// 	public Pessoa getSessionF(SecurityContext context) {
// 		if (context instanceof SecurityContext) {
// 			Authentication authentication = context.getAuthentication();
// 			if (authentication instanceof Authentication) {
// 				Pessoa pessoa = new PessoaFisica();
//
// 				pessoa.setEmail(authentication.getName());
//
// 				// Carrega usuário a partir do email obtido
// 				pessoa = this.findByEmail(pessoa);
//
// 				// Carrega todos os outros atributos do usuário, a partir do
// 				// usuário atual
// 				return pessoa;
// 			}
// 		}
// 		return null;
// 	}
 
// 	public PasswordEncoder getEncoder() {
// 		return this.passwordEncoder;
// 	}
 }