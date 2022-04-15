package com.tamara.letvet.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tamara.letvet.domain.Pacientepet;
import com.tamara.letvet.domain.dtos.PacientepetDTO;
import com.tamara.letvet.services.PacientepetService;

@RestController
@RequestMapping(value = "/pacientepet")
public class PacientepetResource {
	
	@Autowired
	private PacientepetService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PacientepetDTO> findById(@PathVariable Integer id){
		Pacientepet obj = this.service.findById(id);
		return ResponseEntity.ok().body(new PacientepetDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<PacientepetDTO>> findAll(){
		List<Pacientepet> list = service.findAll();
		List<PacientepetDTO> listDTO = list.stream().map(obj -> new PacientepetDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<PacientepetDTO> create(@Valid @RequestBody PacientepetDTO objDTO){
		Pacientepet newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PacientepetDTO> update(@PathVariable Integer id, @Valid @RequestBody PacientepetDTO objDTO){
		Pacientepet obj = service.update(id, objDTO); 
		return ResponseEntity.ok().body(new PacientepetDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PacientepetDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
