package com.tamara.letvet.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tamara.letvet.domain.Medvet;
import com.tamara.letvet.domain.dtos.MedvetDTO;
import com.tamara.letvet.services.MedvetService;

@RestController
@RequestMapping(value = "/medvet")
public class MedvetResource {
	
	@Autowired
	private MedvetService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MedvetDTO> findById(@PathVariable Integer id){
		Medvet obj = this.service.findById(id);
		return ResponseEntity.ok().body(new MedvetDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<MedvetDTO>> findAll(){
		List<Medvet> list = service.findAll();
		List<MedvetDTO> listDTO = list.stream().map(obj -> new MedvetDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<MedvetDTO> create(@Valid @RequestBody MedvetDTO objDTO){
		Medvet newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MedvetDTO> update(@PathVariable Integer id, @Valid @RequestBody MedvetDTO objDTO){
		Medvet obj = service.update(id, objDTO); 
		return ResponseEntity.ok().body(new MedvetDTO(obj));
	}
}
