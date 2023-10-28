package com.param.jwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/test")
	@PreAuthorize("hasRole('ADMIN')")
	public String test() {
		return "Request Received";
	}
}