package com.param.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.param.jwt.entities.User;
import com.param.jwt.repositories.UserRepository;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("param", this.passwordEncoder.encode("java"), "param@gmail.com", "ROLE_ADMIN");
		userRepository.save(user);
		user = new User("user", this.passwordEncoder.encode("java"), "user@gmail.com", "ROLE_NORMAL");
		userRepository.save(user);
	}

}
