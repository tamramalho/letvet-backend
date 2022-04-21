package com.tamara.letvet.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamara.letvet.domain.Consulta;
import com.tamara.letvet.domain.Medvet;
import com.tamara.letvet.domain.Pacientepet;
import com.tamara.letvet.domain.dtos.ConsultaDTO;
import com.tamara.letvet.domain.enums.Prioridade;
import com.tamara.letvet.domain.enums.Status;
import com.tamara.letvet.repositories.ConsultaRepository;
import com.tamara.letvet.services.exceptions.ObjectnotFoundException;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	
	@Autowired
	private MedvetService medvetService;
	
	@Autowired
	private PacientepetService pacientepetService;
	
	public Consulta findById(Integer id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Consulta> findAll() {
		return repository.findAll();
	}

	public Consulta create(@Valid ConsultaDTO objDTO) {
		return repository.save(newConsulta(objDTO));
	}
	
	private Consulta newConsulta(ConsultaDTO obj) {
		Medvet medvet = medvetService.findById(obj.getMedvet());
		Pacientepet pacientepet = pacientepetService.findById(obj.getPacientepet());
		
		Consulta consulta = new Consulta();
		
		if(obj.getId() != null) {
			consulta.setId(obj.getId());
		}
		consulta.setMedvet(medvet);
		consulta.setPacientepet(pacientepet);
		consulta.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		consulta.setStatus(Status.toEnum(obj.getStatus()));
		consulta.setTitulo(obj.getTitulo());
		consulta.setObservacoes(obj.getObservacoes());
		return consulta;
	}
}