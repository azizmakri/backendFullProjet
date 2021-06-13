package com.UniversAfrica.controllers;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UniversAfrica.models.ERole;
import com.UniversAfrica.models.Etudiant;
import com.UniversAfrica.models.Role;
import com.UniversAfrica.models.User;
import com.UniversAfrica.payload.request.LoginEtudiantRequest;
import com.UniversAfrica.payload.request.LoginRequest;
import com.UniversAfrica.payload.request.SignupEtudiantRequest;
import com.UniversAfrica.payload.request.SignupRequest;
import com.UniversAfrica.payload.response.JwtEtudiantResponse;
import com.UniversAfrica.payload.response.JwtResponse;
import com.UniversAfrica.payload.response.MessageResponse;
import com.UniversAfrica.repository.EtudiantRepository;
import com.UniversAfrica.repository.RoleRepository;
import com.UniversAfrica.repository.UserRepository;
import com.UniversAfrica.security.exception.AppException;
import com.UniversAfrica.security.jwt.JwtUtils;
import com.UniversAfrica.security.services.EtudiantDetailsImpl;
import com.UniversAfrica.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 8080)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;
	@Autowired
	EtudiantRepository etudiantRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		Role USER = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new AppException("Admin Role not set."));
		user.setRoles(Collections.singleton(USER));
		
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	
	
	
	
	@PostMapping("/signinEtudiant")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginEtudiantRequest loginEtudiantRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginEtudiantRequest.getCin(), loginEtudiantRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		EtudiantDetailsImpl userDetails = (EtudiantDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtEtudiantResponse(jwt,
				 userDetails.getId(), 
				 userDetails.getNom(),
				 userDetails.getPrenom(),
				 userDetails.getTel(),
				 userDetails.getPays(),
				 userDetails.getType_bac(),
				 userDetails.getMoyenne_bac(),
				 userDetails.getType_bac(),
				 userDetails.getCin(),
				 userDetails.getEmail(),
				 roles));
	}
	
	
	
	
	
	
	
	@PostMapping("/signupEtudiant")
	public ResponseEntity<?> registerEtudiant(@Valid @RequestBody SignupEtudiantRequest signUpEtudiantRequest) {
		if (etudiantRepository.existsByCin(signUpEtudiantRequest.getCin())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Cin is already taken!"));
		}

		if (etudiantRepository.existsByEmail(signUpEtudiantRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Etudiant etudiant = new Etudiant(signUpEtudiantRequest.getCin(), 
							 signUpEtudiantRequest.getEmail(),
							 signUpEtudiantRequest.getNom(),
							 signUpEtudiantRequest.getPrenom(),
							 signUpEtudiantRequest.getTel(),
							 signUpEtudiantRequest.getPays(),
							 signUpEtudiantRequest.getType_bac(),
							 signUpEtudiantRequest.getMoyenne_bac(),
							 signUpEtudiantRequest.getCode_fac(),
							 
							 encoder.encode(signUpEtudiantRequest.getPassword()));
		Role USER = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));
		etudiant.setRoles(Collections.singleton(USER));
		
		etudiantRepository.save(etudiant);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	
	
	
	
	
	
}
