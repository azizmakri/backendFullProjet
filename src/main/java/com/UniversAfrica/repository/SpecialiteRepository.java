package com.UniversAfrica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UniversAfrica.models.Metier;
import com.UniversAfrica.models.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Long>{
	Optional<Specialite> findByNom(String nom);

}
