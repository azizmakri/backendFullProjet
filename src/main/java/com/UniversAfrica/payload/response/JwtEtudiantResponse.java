package com.UniversAfrica.payload.response;

import java.util.List;

public class JwtEtudiantResponse {

	public JwtEtudiantResponse(String token, Long id, String cin, String nom, String prenom, String tel, String pays,
			String type_bac, String moyenne_bac, String code_fac, String email, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.pays = pays;
		this.type_bac = type_bac;
		this.moyenne_bac = moyenne_bac;
		this.code_fac = code_fac;
		this.email = email;
		this.roles = roles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	private String token;
	private String type = "Bearer";
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	private String tel;
	private String pays;
	private String type_bac;
	private String moyenne_bac;
	private String code_fac;
	private String email;
	private List<String> roles;

}
