package com.UniversAfrica.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.UniversAfrica.models.Etudiant;
import com.UniversAfrica.models.User;
import com.UniversAfrica.repository.EtudiantRepository;
import com.UniversAfrica.repository.UserRepository;

@Service
public class EtudiantDetailsServiceImpl implements UserDetailsService {
	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String cin) throws UsernameNotFoundException {
		Etudiant etudiant = etudiantRepository.findByCin(cin)
				.orElseThrow(() -> new UsernameNotFoundException("Etudiant Not Found with cin: " + cin));

		return EtudiantDetailsImpl.build(etudiant);
	}

}
