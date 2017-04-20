package br.edu.ifrs.canoas.lds.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifrs.canoas.lds.domain.User;
import br.edu.ifrs.canoas.lds.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping("/")
	public String index(Model model){ //nao sei se troco o index para new user(Model model)
		model.addAttribute("users", new ArrayList<User>());
		model.addAttribute("user", new User());
		return "index";
	}

	@PostMapping("/save")
	public String save(Model model, @Valid User user){
		//userSerivce.save(user);
		return "index";
	}
}
