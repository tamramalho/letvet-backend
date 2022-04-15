package com.tamara.letvet.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamara.letvet.domain.Pacientepet;
import com.tamara.letvet.domain.Pessoa;
import com.tamara.letvet.domain.dtos.PacientepetDTO;
import com.tamara.letvet.repositories.PacientepetRepository;
import com.tamara.letvet.repositories.PessoaRepository;
import com.tamara.letvet.services.exceptions.DataIntegrityViolationException;
import com.tamara.letvet.services.exceptions.ObjectnotFoundException;

@Service
public class PacientepetService {
	
	@Autowired
	private PacientepetRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pacientepet findById(Integer id) {
		Optional<Pacientepet> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Pacientepet> findAll() {
		return repository.findAll();
	}

	public Pacientepet create(PacientepetDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Pacientepet newObj= new Pacientepet(objDTO);
		return repository.save(newObj);
	}
	
	public Pacientepet update(Integer id, @Valid PacientepetDTO objDTO) {
		objDTO.setId(id);
		Pacientepet oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Pacientepet(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Pacientepet obj = findById(id);
		if(obj.getConsultas().size() > 0) {
			throw new DataIntegrityViolationException("O paciente possui ordens de serviço e não pode ser deletado!");
		}
		repository.deleteById(id);
	}
	
	private void validaPorCpfEEmail(PacientepetDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}
}
