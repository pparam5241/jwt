package com.param.jwt.models;

import lombok.Data;

@Data
public class JwtRequest {
	private String userName;
	private String password;
}