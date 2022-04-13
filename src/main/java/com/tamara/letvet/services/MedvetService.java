package com.tamara.letvet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamara.letvet.domain.Medvet;
import com.tamara.letvet.repositories.MedvetRepository;
import com.tamara.letvet.services.exceptions.ObjectnotFoundException;

@Service
public class MedvetService {
	
	@Autowired
	private MedvetRepository repository;
	
	public Medvet findById(Integer id) {
		Optional<Medvet> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Medvet> findAll() {
		return repository.findAll();
	}
}
