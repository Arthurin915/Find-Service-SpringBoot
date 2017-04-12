package br.edu.ifrs.canoas.lds.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	 
}
