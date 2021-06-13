package com.UniversAfrica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UniversAfrica.models.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	Optional<Etudiant> findByCin(String cin);

	Boolean existsByCin(String cin);

	Boolean existsByEmail(String email);
}
