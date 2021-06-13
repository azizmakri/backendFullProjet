package com.UniversAfrica.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupEtudiantRequest {
    @NotBlank
    @Size(min = 8, max = 20)
    private String cin;
    @NotBlank
    @Size(min = 3, max = 20)
    private String nom;
    @NotBlank
    @Size(min = 3, max = 20)
    private String prenom;


	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getType_bac() {
		return type_bac;
	}

	public void setType_bac(String type_bac) {
		this.type_bac = type_bac;
	}

	public String getMoyenne_bac() {
		return moyenne_bac;
	}

	public void setMoyenne_bac(String moyenne_bac) {
		this.moyenne_bac = moyenne_bac;
	}

	public String getCode_fac() {
		return code_fac;
	}

	public void setCode_fac(String code_fac) {
		this.code_fac = code_fac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotBlank
    @Size(min = 8, max = 20)
    private String tel;
    @NotBlank
    @Size(min = 3, max = 30)
    private String pays;
    @NotBlank
    @Size( max = 20)
    private String type_bac;
    @NotBlank
    @Size( max = 20)
    private String moyenne_bac;
    @NotBlank
    @Size(min = 3, max = 20)
    private String code_fac;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  

 

}
