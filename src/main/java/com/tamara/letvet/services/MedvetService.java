package com.tamara.letvet.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tamara.letvet.domain.Medvet;
import com.tamara.letvet.domain.Pessoa;
import com.tamara.letvet.domain.dtos.MedvetDTO;
import com.tamara.letvet.repositories.MedvetRepository;
import com.tamara.letvet.repositories.PessoaRepository;
import com.tamara.letvet.services.exceptions.DataIntegrityViolationException;
import com.tamara.letvet.services.exceptions.ObjectnotFoundException;

@Service
public class MedvetService {
	
	@Autowired
	private MedvetRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Medvet findById(Integer id) {
		Optional<Medvet> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Medvet> findAll() {
		return repository.findAll();
	}

	public Medvet create(MedvetDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		Medvet newObj= new Medvet(objDTO);
		return repository.save(newObj);
	}
	
	public Medvet update(Integer id, @Valid MedvetDTO objDTO) {
		objDTO.setId(id);
		Medvet oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Medvet(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Medvet obj = findById(id);
		if(obj.getConsultas().size() > 0) {
			throw new DataIntegrityViolationException("O médico possui ordens de serviço e não pode ser deletado!");
		}
		repository.deleteById(id);
	}
	
	private void validaPorCpfEEmail(MedvetDTO objDTO) {
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
