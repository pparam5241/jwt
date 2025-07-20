package com.param.jwt.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.param.jwt.configuration.JwtHelper;
import com.param.jwt.models.JwtRequest;
import com.param.jwt.models.JwtResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

	private final UserDetailsService userDetailsService;
	private final AuthenticationManager manager;
	private final JwtHelper helper;

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		log.info(request.toString());
		this.doAuthenticate(request.getUserName(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
		String token = this.helper.generateToken(userDetails);

		JwtResponse response = new JwtResponse(token, request.getUserName());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}
	}

	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}
}