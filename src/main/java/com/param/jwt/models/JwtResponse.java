package com.param.jwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
	private String jwtToken;
	private String userName;
}