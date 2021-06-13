package com.UniversAfrica.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.UniversAfrica.models.Specialite;
import com.UniversAfrica.repository.SpecialiteRepository;
import com.UniversAfrica.security.exception.ResourceNotFoundException;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SpecialiteController {

	@Autowired
	private SpecialiteRepository specialiteRepository;
	
	// get all specialites
	@GetMapping("/specialites")
	public List<Specialite> getAllSpecialites(){
		return specialiteRepository.findAll();
	}		
	
	// create specialite rest api
	@PostMapping("/specialites")
	public Specialite createSpecialite(@RequestBody Specialite specialite) {
		return specialiteRepository.save(specialite);
	}
	
	// get specialite by id rest api
	@GetMapping("/specialites/{id}")
	public ResponseEntity<Specialite> getSpecialiteById(@PathVariable Long id) {
		Specialite specialite = specialiteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Specialite not exist with id :" + id));
		return ResponseEntity.ok(specialite);
	}
	
	// get specialite by nom rest api
	@GetMapping
	public ResponseEntity<Specialite> getSpecialiteByNom(@PathVariable String nom) {
		Specialite specialite = specialiteRepository.findByNom(nom)
				.orElseThrow(() -> new ResourceNotFoundException("Specialite not exist with id :" + nom));
		return ResponseEntity.ok(specialite);
	}
	
	
	// update specialite rest api
	
	@PutMapping("/specialites/{id}")
	public ResponseEntity<Specialite> updateSpecialite(@PathVariable Long id, @RequestBody Specialite specialiteDetails){
		Specialite specialite = specialiteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Specialite not exist with id :" + id));
		
		specialite.setNom(specialiteDetails.getNom());
		specialite.setDescription(specialiteDetails.getDescription());
		
		
		Specialite updatedSpecialite = specialiteRepository.save(specialite);
		return ResponseEntity.ok(updatedSpecialite);
	}
	
	// delete specialite rest api
	@DeleteMapping("/specialites/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSpecialite(@PathVariable Long id){
		Specialite specialite = specialiteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Specialite not exist with id :" + id));
		
		specialiteRepository.delete(specialite);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
}
