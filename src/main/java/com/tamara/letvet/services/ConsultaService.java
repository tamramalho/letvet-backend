package com.tamara.letvet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamara.letvet.domain.Consulta;
import com.tamara.letvet.repositories.ConsultaRepository;
import com.tamara.letvet.services.exceptions.ObjectnotFoundException;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	
	public Consulta findById(Integer id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Consulta> findAll() {
		return repository.findAll();
	}
}
