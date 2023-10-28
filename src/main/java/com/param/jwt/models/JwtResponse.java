package com.param.jwt.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String jwtToken;
	private String userName;
	private Collection<? extends GrantedAuthority> role;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUserName() {
		return userName;
	}

	public Collection<? extends GrantedAuthority> getRole() {
		return role;
	}

	public void setRole(Collection<? extends GrantedAuthority> role) {
		this.role = role;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public JwtResponse(String jwtToken, String userName) {
		super();
		this.jwtToken = jwtToken;
		this.userName = userName;
	}

	public JwtResponse(String jwtToken, String userName, Collection<? extends GrantedAuthority> role) {
		super();
		this.jwtToken = jwtToken;
		this.userName = userName;
		this.role = role;
	}

	public JwtResponse() {
		super();
	}
}