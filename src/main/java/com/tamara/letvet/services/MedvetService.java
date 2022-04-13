package com.tamara.letvet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamara.letvet.domain.Medvet;
import com.tamara.letvet.repositories.MedvetRepository;

@Service
public class MedvetService {
	
	@Autowired
	private MedvetRepository repository;
	
	public Medvet findById(Integer id) {
		Optional<Medvet> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
