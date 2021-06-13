package com.UniversAfrica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.UniversAfrica.models.Metier;

@Repository
public interface MetierRepository extends JpaRepository<Metier, Long> {

	@Query("SELECT m FROM Metier m  where m.nom like :nom")
	List<Metier> getAllMetiers(@Param("nom") String nom);

	Optional<Metier> findByNom(String nom);

}