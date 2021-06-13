package com.UniversAfrica.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "facultes")
public class Faculte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "description")
	private String description;
	@Column(name = "code_fac")
	private String code_fac;
	@ManyToOne
	private Specialite specialite;
	protected Faculte() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getCode_fac() {
		return code_fac;
	}
	public void setCode_fac(String code_fac) {
		this.code_fac = code_fac;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	protected Faculte(long id, String nom, String description, String code_fac, Specialite specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.code_fac = code_fac;
		this.specialite = specialite;
	}


}
