package com.UniversAfrica.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "specialites")
public class Specialite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "description")
	private String description;

	protected Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	private Metier metier;
	@JsonIgnore
	@OneToMany(mappedBy = "specialite")
	private List<Faculte> facultes;

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public List<Faculte> getFacultes() {
		return facultes;
	}

	public void setFacultes(List<Faculte> facultes) {
		this.facultes = facultes;
	}


	protected Specialite(long id, String nom, String description, Metier metier, List<Faculte> facultes) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.metier = metier;
		this.facultes = facultes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
