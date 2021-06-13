package com.UniversAfrica.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.UniversAfrica.models.Etudiant;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EtudiantDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String cin;

	private String email;
	private String nom;
	private String prenom;
	private String tel;
	private String pays;
	private String type_bac;
	private String moyenne_bac;
	private String code_fac;
	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;


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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public static EtudiantDetailsImpl build(Etudiant etudiant) {
		List<GrantedAuthority> authorities = etudiant.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new EtudiantDetailsImpl(
				etudiant.getId(), 
				etudiant.getCin(), 
				etudiant.getEmail(),
				etudiant.getPassword(),
				etudiant.getTel(),
				etudiant.getPays(),
				etudiant.getNom(),
				etudiant.getPrenom(),
				etudiant.getType_bac(),
				etudiant.getMoyenne_bac(),
				etudiant.getCode_fac(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}



	protected EtudiantDetailsImpl(Long id, String cin, String email, String nom, String prenom, String tel, String pays,
			String type_bac, String moyenne_bac, String code_fac, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
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
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EtudiantDetailsImpl etudiant = (EtudiantDetailsImpl) o;
		return Objects.equals(id, etudiant.id);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


}