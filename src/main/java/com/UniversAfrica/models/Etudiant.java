package com.UniversAfrica.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "etudiants", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "cin"),
			@UniqueConstraint(columnNames = "email") 
		})
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 20)
	private String cin;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	@NotBlank
	@Size(max = 20)
	private String nom;
	@NotBlank
	@Size(max = 20)
	private String prenom;
	@NotBlank
	@Size(max = 20)
	private String tel;
	@NotBlank
	@Size(max = 20)
	private String pays;
	@NotBlank
	@Size(max = 20)
	private String type_bac;
	@NotBlank
	@Size(max = 20)
	private String moyenne_bac;
	@NotBlank
	@Size(max = 20)
	private String code_fac;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}





	public Etudiant(@NotBlank @Size(max = 20) String cin, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String prenom,
			@NotBlank @Size(max = 20) String tel, @NotBlank @Size(max = 20) String pays,
			@NotBlank @Size(max = 20) String type_bac, @NotBlank @Size(max = 20) String moyenne_bac,
			@NotBlank @Size(max = 20) String code_fac, @NotBlank @Size(max = 120) String password) {
		super();
		this.cin = cin;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.pays = pays;
		this.type_bac = type_bac;
		this.moyenne_bac = moyenne_bac;
		this.code_fac = code_fac;
		this.password = password;
	}





	@NotBlank
	@Size(max = 120)
	private String password;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "etudiant_roles",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
