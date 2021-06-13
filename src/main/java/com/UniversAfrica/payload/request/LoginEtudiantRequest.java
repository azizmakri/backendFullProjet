package com.UniversAfrica.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginEtudiantRequest {
	@NotBlank
	private String cin;

	@NotBlank
	private String password;

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
