package com.UniversAfrica.controllers;

import java.util.Arrays;
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

import com.UniversAfrica.dto.GetMetiersRequest;
import com.UniversAfrica.models.Metier;
import com.UniversAfrica.repository.MetierRepository;
import com.UniversAfrica.security.exception.ResourceNotFoundException;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class MetierController {

	@Autowired
	private MetierRepository metierRepository;
	
	// get all metiers
	@PostMapping("/metiers")
	public List<Metier> getAllMetiers(@RequestBody GetMetiersRequest request){
		
		String input = "";
		if (request.getName() == null || request.getName().equals("")) {
			input = "%";
		}else {
			input = request.getName();
		}
		return metierRepository.getAllMetiers(input);
	}		
	
	// create metier rest api
	@PostMapping("/createMetiers")
	public Metier createMetier(@RequestBody Metier metier) {
		return metierRepository.save(metier);
	}
	
	// get metier by id rest api
	@GetMapping("/metiers/{id}")
	public ResponseEntity<Metier> getMetierById(@PathVariable Long id) {
		Metier metier = metierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Metier not exist with id :" + id));
		return ResponseEntity.ok(metier);
	}
	
	// update metier rest api
	
	@PutMapping("/metiers/{id}")
	public ResponseEntity<Metier> updateMetier(@PathVariable Long id, @RequestBody Metier metierDetails){
		Metier metier = metierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Metier not exist with id :" + id));
		
		metier.setNom(metierDetails.getNom());
		metier.setDescription(metierDetails.getDescription());
		
		
		Metier updatedMetier = metierRepository.save(metier);
		return ResponseEntity.ok(updatedMetier);
	}
	
	// delete metier rest api
	@DeleteMapping("/metiers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMetier(@PathVariable Long id){
		Metier metier = metierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Metier not exist with id :" + id));
		
		metierRepository.delete(metier);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	@GetMapping("/Search")
	public ResponseEntity<Metier> getMetierByNom(@PathVariable String nom) {
		Metier metier = metierRepository.findByNom(nom)
				.orElseThrow(() -> new ResourceNotFoundException("Metier not exist with id :" + nom));
		return ResponseEntity.ok(metier);
	}
	
	
	
}