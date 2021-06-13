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

import com.UniversAfrica.models.Faculte;
import com.UniversAfrica.repository.FaculteRepository;
import com.UniversAfrica.security.exception.ResourceNotFoundException;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class FaculteController {

	@Autowired
	private FaculteRepository faculteRepository;
	
	// get all facultes
	@GetMapping("/facultes")
	public List<Faculte> getAllFacultes(){
		return faculteRepository.findAll();
	}		
	
	// create faculte rest api
	@PostMapping("/facultes")
	public Faculte createFaculte(@RequestBody Faculte faculte) {
		return faculteRepository.save(faculte);
	}
	
	// get faculte by id rest api
	@GetMapping("/facultes/{id}")
	public ResponseEntity<Faculte> getFaculteById(@PathVariable Long id) {
		Faculte faculte = faculteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Faculte not exist with id :" + id));
		return ResponseEntity.ok(faculte);
	}
	
	// update faculte rest api
	
	@PutMapping("/facultes/{id}")
	public ResponseEntity<Faculte> updateFaculte(@PathVariable Long id, @RequestBody Faculte faculteDetails){
		Faculte faculte = faculteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Faculte not exist with id :" + id));
		
		faculte.setNom(faculteDetails.getNom());
		faculte.setDescription(faculteDetails.getDescription());
		faculte.setCode_fac(faculteDetails.getCode_fac());
		
		Faculte updatedFaculte = faculteRepository.save(faculte);
		return ResponseEntity.ok(updatedFaculte);
	}
	
	// delete faculte rest api
	@DeleteMapping("/facultes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteFaculte(@PathVariable Long id){
		Faculte faculte = faculteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Faculte not exist with id :" + id));
		
		faculteRepository.delete(faculte);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
}
